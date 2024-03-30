package com.project.GrabYourTickets.Controllers;

import com.project.GrabYourTickets.Entity.Movie;
import com.project.GrabYourTickets.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movieDto) {
        Movie createdMovie = movieService.createMovie(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long movieId, @RequestBody Movie movieDto) {
        Movie updatedMovie = movieService.updateMovie(movieId, movieDto);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.noContent().build();
    }
}
