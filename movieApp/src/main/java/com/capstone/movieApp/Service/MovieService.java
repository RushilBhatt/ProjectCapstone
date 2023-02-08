
package com.capstone.movieApp.Service;

import com.capstone.movieApp.Model.Movie;
import com.capstone.movieApp.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    //user view all movies
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    //admin add new movies
    public Movie saveMovies(Movie movie) {
        return movieRepo.save(movie);
    }

    public Movie findMovieById(int id) {
        return movieRepo.findById(id).orElse(null);
    }



}


