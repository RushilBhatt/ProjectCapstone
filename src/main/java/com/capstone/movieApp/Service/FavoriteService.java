/*
package com.capstone.movieApp.Service;

import com.capstone.movieApp.Model.Favourite;
import com.capstone.movieApp.Model.Movie;
import com.capstone.movieApp.Model.User;
import com.capstone.movieApp.Repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepo;

    @Autowired
    private UserLoginService userService;

    @Autowired
    private MovieService movieService;


    public List<Favourite> getFavoritesByUser(User user) {
        return favoriteRepo.findByUser(user);
    }

    public void saveFavourite(Favourite favourite) {
        Movie movie = movieService.findMovieById(favourite.getMovie().getMovieId());
        favourite.setMovie(movie);
        favoriteRepo.save(favourite);
    }
}
*/