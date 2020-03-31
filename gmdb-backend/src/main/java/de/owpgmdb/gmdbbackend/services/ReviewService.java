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
 * The ReviewSevice manages Reviews and it´s Relation to Other Reviewable Entities.
 * 
 * It is able to add a Review to a Movie and an User.
 */
@Service
public class ReviewService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private MovieRepository movieRepo;

    /**
     * This method adds a Review to a Movie and an User and perists the changes into the Repositiories.
     * @param userId - The Id of the User that Created the Review
     * @param movieId - The Id of the Movie the Review is created for.
     * @param review - The Review that will be related to the Movie and User.
     * @throws IllegalArgumentException If Review is Null
     * @throws NoSuchElementException If User or Movie Id is not found.
     */
    public void addReview(Long userId, Long movieId, Review review) {
        if (review == null) {
            throw new IllegalArgumentException("Review must not be null");
        }
        saveReviewIntoRepository(this.userRepo, userId, review, "User not found");
        saveReviewIntoRepository(this.movieRepo, movieId, review, "Movie not found");

    }

    private <T extends Reviewable> void saveReviewIntoRepository(JpaRepository<T, Long> repo, Long id, Review review, String errorMessage) {
        T dbEntry = repo.findById(id).orElseThrow(() -> new NoSuchElementException(errorMessage));
        dbEntry.addReview(review);
        repo.save(dbEntry);
    }

}