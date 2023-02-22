package com.example.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class RecommendationsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private RowMapper<Recommendations> rowMapper = (ResultSet rs, int rowNum) -> {
        Recommendations matrix = new Recommendations();
        matrix.setMovieId(rs.getInt(1));

        return matrix;
    };

    //fetching the top 5 recommended movies for the given movie id from the database
    //selects the MOVIE_ID column from the MATRIX table where the similarity score of the movie id with other movies is greater than 0.5, and orders the result by the similarity score of the movie id in descending order.
    public List<Recommendations> findAll(int id) {
        String column = "ID_" + id;
        return jdbcTemplate.query("SELECT MOVIE_ID FROM MATRIX WHERE " + column
                + " > 0.5 AND MOVIE_ID <> " + id + " ORDER BY " + column
                + " DESC FETCH FIRST 5 ROWS ONLY", rowMapper);
    }
}

