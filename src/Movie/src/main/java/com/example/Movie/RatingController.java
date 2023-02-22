package com.example.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    @Autowired
    private RatingService service;

    //user ratings upon form submission
    @PostMapping("/addRating")
    public Rating addRating(@RequestBody Rating rating)
    {
        return service.saveRating(rating);
    }


}
