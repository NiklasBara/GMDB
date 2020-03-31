package de.owpgmdb.gmdbbackend.persistence;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import de.owpgmdb.gmdbbackend.models.Movie;
import de.owpgmdb.gmdbbackend.models.Rating;
import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;

/**
 * PersistenceTest
 */
@DataJpaTest
public class MovieTest {

    @Autowired
    private MovieRepository movieRepo;

    @Test
    void dependenciesAreNotNull() {
        Assertions.assertThat(this.movieRepo).isNotNull();
    }

    @Test
    void movieRepoIsEmptyWhenNothingIsAdded() {
        // S SETUP
        List<Movie> expected = Collections.emptyList();
        // E Excersise
        List<Movie> actual = this.movieRepo.findAll();
        // A Assert
        Assertions.assertThat(actual).isEqualTo(expected);
        // (T Teardown)
    }

    @Test
    void canAddMoviesToMovieRepo() {
        Movie newMovie = new Movie("Parasite", 2019L);

        this.movieRepo.save(newMovie);

        List<Movie> actualMovies = this.movieRepo.findAll();

        Assertions.assertThat(actualMovies).hasSize(1);
        Assertions.assertThat(actualMovies.get(0)).isEqualTo(newMovie);

    }

    @Test
    void canDeleteMoviesFromMovieRepo() {
        Movie newMovie = new Movie("Parasite", 2019L);
        List<Movie> expected = Collections.emptyList();

        this.movieRepo.save(newMovie);
        this.movieRepo.deleteById(newMovie.getId());
        List<Movie> actual = this.movieRepo.findAll();

        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    void canUpdateMovie(){
        Movie newMovie = new Movie("Parasite", 2019L);
        this.movieRepo.save(newMovie);
        Movie dbEntry = this.movieRepo.findById(newMovie.getId()).orElseThrow(()-> new AssertionError("Movie not found"));
        dbEntry.setTitle("Knives Out");
        dbEntry.setReleaseYear(2020L);
        this.movieRepo.save(dbEntry);
        Movie actual = this.movieRepo.findById(newMovie.getId()).orElseThrow(()-> new AssertionError("Movie not found"));

        Assertions.assertThat(actual).isEqualTo(dbEntry);

    }

    @Test
    void canAddReviewToMovie(){
        Movie newMovie = new Movie("Parasite", 2019L);
        Review newReview = new Review("Good");

        this.movieRepo.save(newMovie);
        Movie dbEntry = this.movieRepo.findById(newMovie.getId()).orElseThrow(()-> new AssertionError("Movie not found"));
        dbEntry.getReviews().add(newReview);
        this.movieRepo.save(dbEntry);
        Movie actual = this.movieRepo.findById(newMovie.getId()).orElseThrow(()-> new AssertionError("Movie not found"));

        Assertions.assertThat(actual.getReviews()).hasSize(1);
        Assertions.assertThat(actual.getReviews()).isEqualTo(dbEntry.getReviews());
    }

    @Test
    void canAddRatingToMovie(){
        Movie newMovie = new Movie("Parasite", 2019L);
        Rating newRating = new Rating(5);

        this.movieRepo.save(newMovie);
        Movie dbEntry = this.movieRepo.findById(newMovie.getId()).orElseThrow(()-> new AssertionError("Movie not found"));
        dbEntry.getRatings().add(newRating);
        this.movieRepo.save(dbEntry);
        Movie actual = this.movieRepo.findById(newMovie.getId()).orElseThrow(()-> new AssertionError("Movie not found"));

        Assertions.assertThat(actual.getRatings()).hasSize(1);
        Assertions.assertThat(actual.getRatings()).isEqualTo(dbEntry.getRatings());
    }


}