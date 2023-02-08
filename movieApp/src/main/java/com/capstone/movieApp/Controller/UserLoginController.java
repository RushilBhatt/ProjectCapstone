
package com.capstone.movieApp.Controller;

import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Service.UserLoginService;
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

    private User userData;


    //go to login page
    @GetMapping("/user")
    public String loginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userLogin";
    }

    // method without model attribute (original login )
     @PostMapping("/userLogin")
    public String validateLogin(@ModelAttribute("user") User user) {
        userData = user;
        return userService.validateUser(user);
    }




    /*
    @PostMapping("/userLogin")
    public String validateLogin(@ModelAttribute("user") User user, Model model, HttpSession session) {
        String currentUser = userService.validateUser(user);
        if (currentUser != null) {
            session.setAttribute("userData", currentUser);
            model.addAttribute("userData", currentUser);
            return "redirect:/favoriteButton";
        }
        return "userLogin";
    }
   */



}

