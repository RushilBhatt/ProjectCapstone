
package com.capstone.movieApp.Repository;
import com.capstone.movieApp.Model.Admin;
import com.capstone.movieApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    Optional<Admin> findByUsername(String username);
}
