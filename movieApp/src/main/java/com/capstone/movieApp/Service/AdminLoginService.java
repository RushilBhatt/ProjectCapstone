
package com.capstone.movieApp.Service;

import com.capstone.movieApp.Model.Admin;
import com.capstone.movieApp.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
@Service
public class AdminLoginService {

    @Autowired(required = true)
    private AdminRepository adminRepo;

    public String validateAdmin(Admin admin) {
        Optional<Admin> admindata = adminRepo.findById(admin.getUsername());
        if (admindata.isPresent()) {
            Admin existingAdmin = admindata.get();
            if (BCrypt.checkpw(admin.getPassword(), existingAdmin.getPassword())) {
                return "dashboard";
            } else {
                return "invalidCredential";
            }
        } else {
            return "invalidCredential";
        }
    }

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

