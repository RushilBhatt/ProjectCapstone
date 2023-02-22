package com.example.Movie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.annotation.Nullable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "Movies")
public class Movie {

    @Id
    @GeneratedValue
    private int movieId;

    // @OneToMany(mappedBy = "movie")
    // private List<Rating> ratings;

    private String title;

    private String genres;


    private String description;


    private String poster;

    //  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //  private List<Favourite> favorites;


    @Nullable
    private Integer tmdb_Id;


}
