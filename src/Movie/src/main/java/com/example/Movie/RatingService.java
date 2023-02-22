package com.example.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository repo;

    public Rating saveRating(Rating rating)
    {
        return repo.save(rating);
    }
}
