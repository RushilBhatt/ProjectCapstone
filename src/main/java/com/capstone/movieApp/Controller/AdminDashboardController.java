/*
package com.capstone.movieApp.Controller;
import com.capstone.movieApp.Model.Admin;
import com.capstone.movieApp.Model.Movie;
//import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Service.AdminLoginService;
import com.capstone.movieApp.Service.MovieService;
import com.capstone.movieApp.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminDashboardController {

    @Autowired(required = true)
    private AdminLoginService adminService;

    @Autowired(required = true)
    private UserLoginService userService;

    @Autowired(required= true)
    private MovieService movieService;


    //go to add user link - dashboard
    @GetMapping("/addUserLink")
    public String addUserLink(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "UserRegister";
    }

    //admin succesfully add or not able to add user
    @PostMapping("/UserRegistration")
    public String userRegister(@ModelAttribute("user") User user) {
        if (userService.registerUser(user)) {
            return "success";
        } else {
            return "unsucessfull";
        }
    }

    //go to add movie link - dashboard
    @GetMapping("/addMovieLink")
    public String addMovieLink(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "addMovie";
    }

    //done
    @PostMapping("/addingMovie")
    public String addMovie(Movie movie) {
        movieService.saveMovies(movie);
        return "success";
    }
}
*/