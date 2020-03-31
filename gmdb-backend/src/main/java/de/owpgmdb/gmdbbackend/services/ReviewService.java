package de.owpgmdb.gmdbbackend.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.Reviewable;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * ReviewService
 */
@Service
public class ReviewService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private MovieRepository movieRepo;

    public Review addReview(Long userId, Long movieId, Review review) {
        if (review == null) {
            throw new IllegalArgumentException("Review must not be null");
        }
        saveReviewIntoRepository(this.userRepo, userId, review, "User not found");
        saveReviewIntoRepository(this.movieRepo, movieId, review, "Movie not found");

        return null;
    }

    private <T extends Reviewable> void saveReviewIntoRepository(JpaRepository<T, Long> repo, Long id, Review review, String errorMessage) {
        T dbEntry = repo.findById(id).orElseThrow(() -> new NoSuchElementException(errorMessage));
        dbEntry.addReview(review);
        repo.save(dbEntry);
    }

}