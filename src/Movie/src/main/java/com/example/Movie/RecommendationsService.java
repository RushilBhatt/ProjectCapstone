package com.example.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationsService {

    @Autowired
    private RecommendationsRepository repo;

    public List<Recommendations> findAllMovies(int id)
    {
        return repo.findAll(id);
    }
}