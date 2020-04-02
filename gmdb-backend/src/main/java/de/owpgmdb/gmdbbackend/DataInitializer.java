package de.owpgmdb.gmdbbackend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.owpgmdb.gmdbbackend.models.Movie;
import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.models.UserRole;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;
import de.owpgmdb.gmdbbackend.repositories.ReviewRepository;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

@Component
@Profile("!test")
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... strings) {
        createTestData();
    }
    @Transactional
    private void createTestData() {

        Movie movie1 = movieRepository.save(new Movie("Film 1", 1998L));
        Movie movie2 = movieRepository.save(new Movie("Film 2", 2001L));
        Movie movie3 = movieRepository.save(new Movie("Film 3", 2020L));

        User user1 = userRepository.save(new User("Jens", UserRole.REVIEWER));
        User user2 = userRepository.save(new User("Alois", UserRole.ADMIN));

        Review review1 = reviewRepository.save(new Review("Geiler Film"));

        movie1.addReview(review1);
        user1.addReview(review1);
        
        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));
        userRepository.saveAll(Arrays.asList(user1, user2));

    }
}