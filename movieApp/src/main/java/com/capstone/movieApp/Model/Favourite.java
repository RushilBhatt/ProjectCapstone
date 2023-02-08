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
@Table(name = "favorites")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="movieid")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Favourite (Movie movie,User user) {
        this.movie = movie;
        this.user = user;
    }



}
*/