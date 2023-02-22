
package com.capstone.movieApp.Service;

import com.capstone.movieApp.Model.Admin;
import com.capstone.movieApp.Repository.AdminRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
@Service
public class AdminLoginService {

    @Autowired(required = true)
    private AdminRepository adminRepo;

    //uses findByUsername to find admin that match entered username
    //if admin data is present,check if password match
    //if password match,return dashboard else return invalidCredential
    //if admin not exist,return unauthorized

    public String validateAdmin(Admin admin, HttpServletRequest request) {
        Optional<Admin> admindata = adminRepo.findByUsername(admin.getUsername());
        if (admindata.isPresent()){
            if(BCrypt.checkpw(admin.getPassword(), admindata.get().getPassword())){
                return "dashboard";
         }
            else {
                return "invalidCredential";
            }
        } else {
            return "unauthorized";
        }
    }

    //checks if there is an existing admin with the given name
    //if such admin exist, the method returns false and does not save the new admin.
    //If the username is unique, the method proceeds to create a hashed password using the BCrypt.hashpw method
    //the method then returns true and saves and admin object
    public boolean registerAdmin(Admin admin) {
        Optional<Admin> existingAdmin = adminRepo.findById(admin.getUsername());
        if (existingAdmin.isPresent()) {
            return false;
        } else {
            String password = admin.getPassword();
            //store hashed password using BCrypt
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            admin.setPassword(hashedPassword);
            admin.setConfirmPassword(hashedPassword);
            adminRepo.save(admin);
            return true;
        }
    }


}

