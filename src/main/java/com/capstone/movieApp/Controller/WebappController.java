package com.capstone.movieApp.Controller;

import com.capstone.movieApp.Model.Movie;
import com.capstone.movieApp.Model.Rating;
import com.capstone.movieApp.Model.Favourite;
import com.capstone.movieApp.Model.Recommendations;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.client.RestTemplate;
@Controller
public class WebappController {
    @Autowired
    private RestTemplate restTemplate;

    //user view all movies
    //page redirected after button in welcome page clicked
    @GetMapping("/home")
    public String getAllMovies(Model model) {
        HttpHeaders headers = new HttpHeaders(); // set header of HTTP request
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Movie> entity = new HttpEntity<Movie>(headers); // creates an HttpEntity object with the headers set in previous step
        List<Movie> dataList = restTemplate.exchange("http://localhost:8086/movies", HttpMethod.GET, entity, List.class).getBody(); //send a GET request to Movie API
        model.addAttribute("dataList", dataList); // set dataList to model attribute
        return "userMoviesView";
    }

    //redirect id to movie info controller method
    //id obtained from more details button userMoviesView file
    @GetMapping("/redirectToFindMovieById")
    public String redirectToFindMovieById(@RequestParam("id") int id) {
        return "redirect:/movieinfo/" + id;
    }

    @GetMapping("/movieinfo/{id}")
    public String movieInfoPage(@PathVariable int id, Model model) {

        //user view movie more details by its id
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Movie> entity = new HttpEntity<Movie>(headers);
        Movie dataList = restTemplate.exchange("http://localhost:8086/findMovieById/" + id, HttpMethod.GET, entity, Movie.class).getBody();
        model.addAttribute("dataList", dataList);

        //response received is list of movie recommendations (id)
        HttpHeaders headers2 = new HttpHeaders();
        headers2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Recommendations> entity2 = new HttpEntity<Recommendations>(headers2);
        List<Recommendations> dataId = restTemplate.exchange("http://localhost:8086/recommendations/" + id, HttpMethod.GET, entity2, new ParameterizedTypeReference<List<Recommendations>>() {}).getBody();

        //response received fetch details from /movies/{id} endpoint
        HttpHeaders headers3 = new HttpHeaders();
        headers3.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Movie> entity3 = new HttpEntity<Movie>(headers3);
        List<Movie> dataListMovie = new ArrayList<>();
        //iterating over the list of recommended movies retrieved from the dataId and retrieving details of each recommended
        //movie using the movieId stored in the recommended object.
        for (Recommendations recommend : dataId) {
            //obtain all ids of recommended movies
            int movieId = recommend.getMovieId();
            //For each recommendation, a GET request is made to the /movies/{movieId} endpoint, where movieId is the id of the recommended movie
            List<Movie> recommendedMovies = restTemplate.exchange("http://localhost:8086/movies/" + movieId, HttpMethod.GET, entity3, new ParameterizedTypeReference<List<Movie>>() {}).getBody();
           //store all recommended movies received from each request made inside the for loop
            dataListMovie.addAll(recommendedMovies);
        }
        model.addAttribute("dataListMovie", dataListMovie);
        return "moreDetails";
    }

     //method invoked upon rating form submission
    @PostMapping("/rate")
    public String addRating(@ModelAttribute("rating") Rating rating, Model model)
    {
        //add in new rating by user
        //takes in movieid,userid,movierating and timestamp for new rating
        String timestamp = rating.getTimestamp();
        int movieId = rating.getMovieId();
        int userId = rating.getUserId();
        double movierating = rating.getMovierating();
        int id = rating.getId();
        //creates new rating object using extracted values
        rating = new Rating(id,userId,movieId,movierating,timestamp);
        HttpEntity<Rating> entity = new HttpEntity<Rating>(rating);
        restTemplate.exchange("http://localhost:8086/addRating", HttpMethod.POST, entity, Rating.class).getBody();

        //after rating is added,this method retrieves list of all movies from the endpoint to display at home page
        HttpHeaders headers3 = new HttpHeaders();
        headers3.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Movie> entity3 = new HttpEntity<Movie>(headers3);
        List<Movie> dataList = restTemplate.exchange("http://localhost:8086/movies", HttpMethod.GET, entity3, new ParameterizedTypeReference<List<Movie>>() {}).getBody();
        model.addAttribute("dataList", dataList);
        return "userMoviesView";
    }

    /*Fav*/
    @GetMapping("/fav")
    public String addFav(@RequestParam("id") int id,@RequestParam("userId") int userId, @ModelAttribute("favourite") Favourite favourite, Model model)
    {
        //retrieve id of favourite movie
        int idf = favourite.getId();

        //create new favourite object
        favourite = new Favourite(idf, id, userId);
        HttpEntity<Favourite> entity = new HttpEntity<Favourite>(favourite);
        //add the new favorite movie to the user's list of favorite movies.
        restTemplate.exchange("http://localhost:8086/addFav", HttpMethod.POST, entity, Favourite.class).getBody();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Favourite> entity2 = new HttpEntity<Favourite>(headers);
        //retrieve the updated list of favorite movies for the user with the specified ID.
        List<Favourite> favList = restTemplate.exchange("http://localhost:8086/favs/"+userId, HttpMethod.GET, entity2, new ParameterizedTypeReference<List<Favourite>>(){}).getBody();


        HttpHeaders headers3 = new HttpHeaders();
        headers3.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Movie> entity3 = new HttpEntity<Movie>(headers3);
        List<Movie> dataListmovie = new ArrayList<>();
        //iterates over the list of favorite movies.
        for (Favourite favourite1 : favList) {
            int movieId = favourite1.getMovieId();
            //retrieve the details of the favorite movie with the specified ID.
            List<Movie> favMovies = restTemplate.exchange("http://localhost:8086/movies/" + movieId, HttpMethod.GET, entity3, new ParameterizedTypeReference<List<Movie>>() {}).getBody();
            dataListmovie.addAll(favMovies);
        }
        model.addAttribute("dataList", dataListmovie);
        return "favourite";
    }

    @GetMapping("/viewfavs")
    public String findallFav(Model model, HttpSession session)
    {
        //retrieving a list of all movies that a user has marked as their favorites
        Integer userId = (Integer) session.getAttribute("userid");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Favourite> entity2 = new HttpEntity<Favourite>(headers);
        List<Favourite> favList = restTemplate.exchange("http://localhost:8086/favs/"+userId, HttpMethod.GET, entity2, new ParameterizedTypeReference<List<Favourite>>(){}).getBody();
        List<Integer> dataListid = new ArrayList<>();
        //extract the IDs of all the favorites that belong to the current user session and store them in dataListid
        for (Favourite favourite : favList){
            int favid = favourite.getId();
            dataListid.add(favid);
        }
        model.addAttribute("dataid", dataListid);

        //retrieving the details of each favorite movie that a user has marked.
        HttpHeaders headers3 = new HttpHeaders();
        headers3.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Movie> entity3 = new HttpEntity<Movie>(headers3);
        List<Movie> dataListmovie = new ArrayList<>();
        //iterating over the list of favorite movies retrieved from the favList and retrieving details of each favorite
        // movie using the movieId stored in the favourite object.
        for (Favourite favourite1 : favList) {
            int movieId = favourite1.getMovieId();
            List<Movie> favMovies = restTemplate.exchange("http://localhost:8086/movies/" + movieId, HttpMethod.GET, entity3, new ParameterizedTypeReference<List<Movie>>() {}).getBody();
            dataListmovie.addAll(favMovies);
        }
        //contains details of favourite movies
        model.addAttribute("dataList", dataListmovie);
        return "favourite";
    }

}








