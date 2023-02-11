
package com.capstone.movieApp.Service;

import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
@Service
public class UserLoginService {

    @Autowired(required = true)
    private UserRepository userRepo;

    public String validateUser(User user) {
        Optional<User> userdata = userRepo.findById(user.getUsername());
        if (user.getPassword().equals(userdata.get().getPassword())) {
            return "welcome";
        } else {
            return "invalidCredential";
        }
    }


    public boolean registerUser(User user) {
        Optional<User> existingUser = userRepo.findById(user.getUsername());
        if (existingUser.isPresent()) {
            return false;
        } else {
            userRepo.save(user);
            return true;
        }

    }



    public User getCurrentUser(String username) {
        // Assume that the username of the current user is stored in a variable named "username"
        return userRepo.findByUsername(username);
    }


}
