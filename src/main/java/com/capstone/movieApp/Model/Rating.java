
package com.capstone.movieApp.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Rating {
    @Id
    @GeneratedValue
    private int Id;
    private int userId;
    private int movieId;

    private double movierating;

    private String timestamp;
}







