package com.example.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    public List<Movie> getMovies()
    {
        return repo.findAll();
    }

    public Movie getMovieById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public List<Movie> getMoviesById(int id)

    {
        return repo.findByMovieId(id);
    }

    public Movie saveMovie(Movie movie)
    {
        return repo.save(movie);
    }
}
