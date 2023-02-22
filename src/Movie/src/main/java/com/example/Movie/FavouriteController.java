package com.example.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavouriteController {

    @Autowired
    private FavouriteService service;

    //add movie as favourites
    @PostMapping("/addFav")
    public Favourite addFav(@RequestBody Favourite favourite)
    {
        return service.saveFav(favourite);
    }

    //
    @GetMapping("/favs/{id}")
    public List<Favourite> findallFavouritebyId(@PathVariable int id)
    {
        return service.getFavbyId(id);
    }


}
