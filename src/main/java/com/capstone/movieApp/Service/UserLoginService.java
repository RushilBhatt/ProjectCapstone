
package com.capstone.movieApp.Service;

import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import org.mindrot.jbcrypt.BCrypt;
@Service
public class UserLoginService {

    @Autowired(required = true)
    private UserRepository userRepo;

    //uses findByUsername to find user that match entered username
    //if user,check if password match
    //if password match,return welcome else return invalidCredential
    //if user not exist,return unauthorized
    public String validateUser(User user, HttpServletRequest request) {
        Optional<User> userdata = userRepo.findByUsername(user.getUsername());
        if (userdata.isPresent()) {
            if ((BCrypt.checkpw(user.getPassword(), userdata.get().getPassword()))){
               return "welcome";
        }   else {
               return "invalidCredential";
        }
        }
        else {
               return "unauthorized";
        }
    }

    public boolean registerUser(User user) {
        Optional<User> existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return false;
        } else {
            String password = user.getPassword();
            //store hashed password using BCrypt
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setPassword(hashedPassword);
            user.setConfirm_Password(hashedPassword);
            userRepo.save(user);
            return true;
        }

    }

    //view all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
