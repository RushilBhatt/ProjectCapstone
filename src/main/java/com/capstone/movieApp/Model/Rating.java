/*
package com.capstone.movieApp.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name= "Ratings")
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


  // @ManyToOne
  // @JoinColumn(name = "userid")
  // private User user;

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movie;

    @Column(name="rating")
    private float rating;

    @Column(name="timestamp")
    private Integer timestamp;

    public Rating(Long id,Movie movie, float rating){
        this.id = id;
        this.movie  = movie;
        this.rating = rating;

    }
}
*/

