package de.owpgmdb.gmdbbackend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.owpgmdb.gmdbbackend.models.Movie;
import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.dtos.MovieDTO;
import de.owpgmdb.gmdbbackend.models.dtos.ReviewRequestDTO;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;
import de.owpgmdb.gmdbbackend.services.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/review")
    public ReviewRequestDTO addNewReview(@RequestBody ReviewRequestDTO reviewDTO){
        Review review = null;
        
        if (reviewDTO.getText() != null) {
            review = new Review(reviewDTO.getText());

        }
        reviewService.addReview(reviewDTO.getUserId(), reviewDTO.getMovieId(), review);
        return reviewDTO;
    }
}