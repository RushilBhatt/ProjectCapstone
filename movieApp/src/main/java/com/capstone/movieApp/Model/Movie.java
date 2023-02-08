
package com.capstone.movieApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name= "Movies")
public class Movie {

    @Id
    @Column(name="movie_Id")
    private int movie_Id;

   // @OneToMany(mappedBy = "movie")
   // private List<Rating> ratings;

    @Column(name="title")
    private String title;

    @Column(name="genres")
    private String genres;

    @Column(name="description")
     private String description;

    @Column(name="poster")
   private String poster;

  //  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  private List<Favourite> favorites;

    @Column(name="tmdb_Id")
    private int tmdb_Id;


}




