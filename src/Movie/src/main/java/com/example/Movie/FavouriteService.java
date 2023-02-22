package com.example.Movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {

    @Autowired
    private FavouriteRepository repo;

    public Favourite saveFav(Favourite favourite)
    {
        return repo.save(favourite);
    }

    public List<Favourite> getFavbyId(int id)

    {
        return repo.findByUserId(id);
    }
}
