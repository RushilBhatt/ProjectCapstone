
package com.capstone.movieApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.annotation.Nullable;


import java.sql.Blob;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "Movies")
public class Movie {

    @Id
    private int movie_Id;

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




