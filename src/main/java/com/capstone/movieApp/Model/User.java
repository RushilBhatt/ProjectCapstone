
package com.capstone.movieApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    private String username;





   // @OneToMany(mappedBy = "user")
   // private List<Rating> ratings;



    private String password;



    private String confirm_Password;

   //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  // private List<Favourite> favorites;




}
