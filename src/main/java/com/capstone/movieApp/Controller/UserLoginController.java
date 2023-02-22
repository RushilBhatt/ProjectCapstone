
package com.capstone.movieApp.Controller;

import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Repository.UserRepository;
import com.capstone.movieApp.Service.UserLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserLoginController {

    @Autowired(required = true)
    private UserLoginService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserRepository userRepo;

    private User userData;


    //go to login page
    @GetMapping("/user")
    public String loginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userLogin";
    }
    //method invoked upon login form submission
    //if returned value by validateUser is "welcome", set session for username & id
    @PostMapping("/userLogin")
    public String validateLogin(@ModelAttribute("user") User user, HttpServletRequest request) {
        String result = userService.validateUser(user, request);
        if (result.equals("welcome")) {
            User userdata = userRepo.findByUsername(user.getUsername()).get();
            request.getSession().setAttribute("username", userdata.getUsername());
            request.getSession().setAttribute("userid", userdata.getUserid());
        }
        return result;

    }
}





