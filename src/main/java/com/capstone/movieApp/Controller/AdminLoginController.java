
package com.capstone.movieApp.Controller;

import com.capstone.movieApp.Model.Admin;
import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Repository.AdminRepository;
import com.capstone.movieApp.Service.AdminLoginService;
import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    private AdminRepository adminRepo;

    private Admin adminData;

    //go to admin login page
    //button in registrationSuccess file that redirect admin to the login page
    @GetMapping("/admin")
    public String loginPage(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "adminLogin";
    }

    //method invoked upon login form submission
    //if returned value by validateAdmin is "dashboard", set session
    @PostMapping("/adminLogin")
    public String validateLogin(@ModelAttribute("admin") Admin admin, HttpServletRequest request) {
        String result = adminService.validateAdmin(admin, request);
        if (result.equals("dashboard")) {
            Admin admindata = adminRepo.findByUsername(admin.getUsername()).get();
            request.getSession().setAttribute("username", admindata.getUsername());
        }
        return result;

    }

    //go to admin register page
    @GetMapping("/registerAdmin")
    public String registerPage(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "adminRegister";
    }

    //if registerAdmin in service class return true, then return registrationSuccess
    //if registerAdmin in service class return false, then return registrationError
    @PostMapping("/AdminRegistration")
    public String registerAdmin(@ModelAttribute("admin") Admin admin) {
        if (adminService.registerAdmin(admin)) {
            return "registrationSuccess";
        } else {
            return "registrationError";
        }
    }
}


