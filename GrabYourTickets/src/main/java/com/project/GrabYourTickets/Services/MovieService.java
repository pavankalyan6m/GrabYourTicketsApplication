package com.project.GrabYourTickets.Services;

import com.project.GrabYourTickets.Entity.Movie;
import com.project.GrabYourTickets.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        return movie.orElse(null); // Return null if the movie is not found
    }

    public Movie createMovie(Movie movieDto) {
        // You can add validation and additional logic here
        return movieRepository.save(movieDto);
    }

    public Movie updateMovie(Long movieId, Movie movieDto) {
        Optional<Movie> existingMovie = movieRepository.findById(movieId);

        if (existingMovie.isPresent()) {
            Movie movie = existingMovie.get();
            // Update movie attributes with data from movieDto
            movie.setTitle(movieDto.getTitle());
            movie.setDescription(movieDto.getDescription());
            // Update other attributes as needed

            // Save the updated movie
            return movieRepository.save(movie);
        } else {
            return null; // Movie not found
        }
    }

    public void deleteMovie(Long movieId) {
        // You can add additional logic here, such as checking if the movie exists
        movieRepository.deleteById(movieId);
    }
}
