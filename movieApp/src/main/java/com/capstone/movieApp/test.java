/*
package com.capstone.movieApp;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class test {
    try (
    BufferedReader reader = new BufferedReader(new FileReader("links.csv"))) {
        String line;
        reader.readLine(); // Skip the header row
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            int movieId = Integer.parseInt(fields[0]);
            String imdbId = fields[1];
            int tmdbId = Integer.parseInt(fields[2]);

            // Fetch the poster image and description using the IMDb ID or TMDB ID
            String apiKey = "your_api_key";
            String url = "http://www.omdbapi.com/?apikey=" + apiKey + "&i=" + imdbId;
            try {
                URL omdbUrl = new URL(url);
                HttpURLConnection con = (HttpURLConnection) omdbUrl.openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(5000);
                con.setReadTimeout(5000);
                int status = con.getResponseCode();
                if (status == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer content = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();

                    // Parse the JSON response to extract the poster image URL and movie description
                    JSONObject movie = new JSONObject(content.toString());
                    String posterUrl = movie.getString("Poster");
                    String description = movie.getString("Plot");

                    // Connect to the database
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db", "root", "root");

                    // Prepare the SQL statement to insert the data into the database
                    String sql = "INSERT INTO movies (movie_id, imdb_id, tmdb_id, poster_url, description) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);

                    // Set the parameters for the SQL statement
                    statement.setInt(1, movieId);
                    statement.setString(2, imdbId);
                    statement.setInt(3, tmdbId);
                    statement.setString(4, posterUrl);
                    statement.setString(5, description);

                    // Execute the SQL statement
                    statement.executeUpdate();

                    // Close the connection to the database
                    connection.close();
                } else {
                    System.out.println("Failed to fetch movie information: HTTP status code " + status);
                }
            } catch (Exception e) {
                System.out.println("Failed to fetch movie information: " + e.getMessage());
            }
        }
    } catch (Exception e) {
        System.out.println("Failed to read the CSV file: " + e.getMessage());
    }

}
}

 */
