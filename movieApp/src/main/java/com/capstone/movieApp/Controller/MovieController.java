
package com.capstone.movieApp.Controller;

import com.capstone.movieApp.Model.Movie;
//import com.capstone.movieApp.Model.Rating;
import com.capstone.movieApp.Service.MovieService;
//import com.capstone.movieApp.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

    @Autowired(required = true)
    private MovieService movieService;

    //@Autowired(required = true)
    //private RatingService ratingService;

    //user view movies
    @GetMapping("/home")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "UserMoviesView";
    }

}

/*

    @GetMapping("/movies/{id}")
    public String movieDetails(@PathVariable int id, Model model) {
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "movieRating";
    }

    @PostMapping("/movies/{id}/rate")
    public String rateMovie(@PathVariable int id, @RequestParam float rating) {
        ratingService.save(new Rating(null,movieService.findById(id),rating));
        return "redirect:/movies/{id}";
    }
*/


















