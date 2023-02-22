
package com.capstone.movieApp.Repository;
import com.capstone.movieApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User save(User user);

    Optional<User> findByUsername(String username);
}



