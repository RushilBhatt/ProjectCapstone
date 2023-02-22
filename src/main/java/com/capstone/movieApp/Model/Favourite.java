package com.capstone.movieApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "Favourite")
public class Favourite {

    @Id
    @GeneratedValue
    private int id;
    private int movieId;

    private int userId;
}