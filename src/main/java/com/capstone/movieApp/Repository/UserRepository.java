
package com.capstone.movieApp.Repository;
import com.capstone.movieApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User save(User user);

    User findByUsername(String username);
}



