package de.owpgmdb.gmdbbackend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
            movieDTO.setAverageRating(movie.getRatings()
                .stream()
                .mapToInt(rating -> rating.getScore())
                .average()
                .orElse(-1.0));
                return movieDTO;})
        .collect(Collectors.toList());
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

}