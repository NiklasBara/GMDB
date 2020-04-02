package de.owpgmdb.gmdbbackend;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.owpgmdb.gmdbbackend.models.Movie;
import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.models.UserRole;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) {
       //  createTestDataSmall();
    }

    private void createTestData() {

        Movie movie1 = new Movie("Film 1", 1998L);
        Movie movie2 = new Movie("Film 2", 2001L);
        Movie movie3 = new Movie("Film 3", 2020L);

        User user1 = new User();
        user1.setUsername("Jens");
        user1.setRole(UserRole.REVIEWER);

        User user2 = new User();
        user2.setUsername("Alois");
        user2.setRole(UserRole.REVIEWER);

        Review review1 = new Review("Geiler Film", movie1, user1);
        Review review2 = new Review("Mega Film", movie2, user2);
        Review review3 = new Review("Ultra Streifen", movie1, user2);
        Review review4 = new Review("Yeah", movie2, user1);

        movie1.addReview(review1);
        user1.addReview(review1);

        movie2.addReview(review2);
        user2.addReview(review2);

        movie1.addReview(review3);
        user2.addReview(review3);

        movie2.addReview(review4);
        user1.addReview(review4);

        // Stream.of("Geiler Film", "Mega Film", "Ultra Streifen").forEach(reviewText ->
        // movie1.addReview(new Review(reviewText)));
        // Stream.of("Awesome", "Nice", "I like").forEach(reviewText ->
        // movie2.addReview(new Review(reviewText)));
        // Stream.of("Cool", "Yeah").forEach(reviewText -> movie3.addReview(new
        // Review(reviewText)));

        userRepository.saveAll(Arrays.asList(user1, user2));
        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));
    }

    private void createTestDataSmall() {

        Movie movie1 = new Movie("Film 1", 1998L);

        movieRepository.saveAndFlush(movie1);
    }
}