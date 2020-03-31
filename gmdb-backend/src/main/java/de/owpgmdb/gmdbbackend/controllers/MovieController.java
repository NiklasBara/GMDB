package de.owpgmdb.gmdbbackend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.owpgmdb.gmdbbackend.models.Movie;
import de.owpgmdb.gmdbbackend.models.dtos.MovieDTO;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;

@RestController
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // public MovieController(MovieRepository movieRepository) {
    //     this.movieRepository = movieRepository;
    // }

    @GetMapping("/movies")
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll()
        .stream()
        .map(movie -> {
            MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getTitle(), movie.getReleaseYear());
            return calculateAverageRating(movieDTO, movie);})
        .collect(Collectors.toList());
    }

    private MovieDTO calculateAverageRating(MovieDTO movieDTO, Movie movie) {
         movieDTO.setAverageRating(movie.getRatings()
                .stream()
                .mapToInt(rating -> rating.getScore())
                .average()
                .orElse(-1.0));
        return movieDTO;
        
    }

    @GetMapping("/movies/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {
        Movie movie = movieRepository.getOne(id);
        MovieDTO movieDTO = calculateAverageRating(new MovieDTO(movie.getId(), movie.getTitle(), movie.getReleaseYear()), movie);
        movieDTO.setReviews(movie.getReviews());
        
        return  movieDTO;
    }
}