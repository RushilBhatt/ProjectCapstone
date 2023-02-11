
package com.capstone.movieApp.Repository;
import com.capstone.movieApp.Model.Movie;
import com.capstone.movieApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Integer> {
    Movie save(Movie movie);


}
