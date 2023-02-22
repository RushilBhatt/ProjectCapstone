
package com.capstone.movieApp.Controller;

import com.capstone.movieApp.Model.Movie;
import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Repository.UserRepository;
import com.capstone.movieApp.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class AdminDashboardController {

    @Autowired
    private UserLoginService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepo;


    //go to add user link - in dashboard
    @GetMapping("/addUser")
    public String addUserLink(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "UserRegister";
    }

    //admin able to add or not able to add user
    //if registerUser in service class return true,return success
    //if registerUser in service class return false,return to dashboard
    @PostMapping("/UserRegistration")
    public String userRegister(@ModelAttribute("user") User user) {
        if (userService.registerUser(user)) {
            return "dashboard";
        } else {
            return "unsucessfull";
        }
    }

    //go to add movie link - in dashboard
    @GetMapping("/addMovie")
    public String addMovieLink(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "addMovie";
    }

    //after admin submit add movie
    //return to dashboard after adding movie
    @PostMapping("/addMovie")
    public String addMovie(@ModelAttribute("movie") Movie movie) {
        HttpEntity<Movie> entity = new HttpEntity<Movie>(movie);
        restTemplate.exchange("http://localhost:8086/addMovie", HttpMethod.POST, entity, Movie.class).getBody(); //add Movie API
        return "dashboard";
    }

    //admin view all users
    @GetMapping("/getUsers")
    public String viewUsers(Model model) {
        List<User> userList = userRepo.findAll();
        model.addAttribute("userList", userList);
        return "userView";
    }
}
