/*
package com.capstone.movieApp.Controller;

import com.capstone.movieApp.Model.Movie;
import com.capstone.movieApp.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.capstone.movieApp.Model.Favourite;
import com.capstone.movieApp.Service.FavoriteService;
import com.capstone.movieApp.Service.MovieService;
import com.capstone.movieApp.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoriteController {

    @Autowired(required = true)
    private MovieService movieService;

    @Autowired(required = true)
    private UserLoginService userService;


    @Autowired(required = true)
    private FavoriteService favoriteService;

    //go to favorite button page
    @GetMapping("/favoriteButton")
    public String favoriteButtonPage(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "favoriteButton";
    }

    /*method that gives userid = null in database   (original controller)
    //user favorite movie sent using form
    @PostMapping("/user/add-favorite")
    public String addFavorite(@RequestParam("movieId") int movieId,String username) {
        User user = userService.getCurrentUser(username);
        Movie movie = movieService.findMovieById(movieId);
        Favourite favorite = new Favourite(movie, user);
        favoriteService.saveFavourite(favorite);
        return "redirect:/favoriteButton";
    }



    @PostMapping("/user/add-favorite")
    public String addFavorite(@RequestParam("movieId") int movieId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("userData");
        Movie movie = movieService.findMovieById(movieId);
        Favourite favorite = new Favourite(movie, user);
        favoriteService.saveFavourite(favorite);
        return "redirect:/favoriteButton";
    }




    //user view favorite movies






    //user check favorites









}
*/

