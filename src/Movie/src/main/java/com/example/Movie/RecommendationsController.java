package com.example.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationsController {
    @Autowired
    private RecommendationsService service;

    //receive list of  movie recommendations based on movie with specified id
    @GetMapping("/recommendations/{id}")
    public List<Recommendations> findAllMovies(@PathVariable int id)

    {
        return service.findAllMovies(id);
    }
}