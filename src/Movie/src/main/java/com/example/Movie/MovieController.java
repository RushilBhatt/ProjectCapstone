package com.example.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    //user view all movies
    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return service.getMovies();
    }

    //user get more details of particular movie by id
    @GetMapping("/findMovieById/{id}")
    public Movie findMovieById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    @GetMapping("/movies/{id}")
    public List<Movie> findAllMoviesById(@PathVariable int id) {
        return service.getMoviesById(id);
    }

    //adds movie into database (admin dashboard)
    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie)
    {
        return service.saveMovie(movie);
    }
}
