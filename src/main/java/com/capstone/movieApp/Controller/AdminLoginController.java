
package com.capstone.movieApp.Controller;

import com.capstone.movieApp.Model.Admin;
import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminLoginController {

    @Autowired(required = true)
    private AdminLoginService adminService;

    private Admin adminData;


    //go to login page
    @GetMapping("/admin")
    public String loginPage(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "adminLogin";
    }

    @PostMapping("/adminLogin")
    public String validateLogin(@ModelAttribute("admin") Admin admin) {
        adminData = admin;
        return adminService.validateAdmin(admin);
    }

    //go to register page
    @GetMapping("/registerAdmin")
    public String registerPage(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "adminRegister";
    }

    @PostMapping("/AdminRegistration")
    public String registerAdmin(@ModelAttribute("admin") Admin admin) {
        if (adminService.registerAdmin(admin)) {
            return "registrationSuccess";
        } else {
            return "registrationError";
        }
    }




}
