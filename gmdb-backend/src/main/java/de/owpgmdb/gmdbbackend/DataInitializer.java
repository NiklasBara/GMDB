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

        Movie movie1 = movieRepository.save(new Movie("King Kong", 2005L));
        movie1.setGenre("Action, Adventure, Drama");
        movie1.setRuntime(187);
        
        Movie movie2 = movieRepository.save(new Movie("Star Wars", 1977L));
        movie2.setGenre("Action, Adventure, Fantasy");
        movie2.setRuntime(121);

        Movie movie3 = movieRepository.save(new Movie("Inception", 2010L));
        movie3.setGenre("Action, Adventure, Sci-Fi");
        movie3.setRuntime(148);

        Movie movie4 = movieRepository.save(new Movie("The Final Programme", 1973L));
        movie4.setGenre("Sci-Fi");
        movie4.setRuntime(81);

        Movie movie5 = movieRepository.save(new Movie("Fight Club", 1999L));
        movie5.setGenre("Drama");
        movie5.setRuntime(139);

        Movie movie6 = movieRepository.save(new Movie("Matrix", 1999L));
        movie6.setGenre("Action, Sci-Fi");
        movie6.setRuntime(136);

        Movie movie7 = movieRepository.save(new Movie("Sieben", 1995L));
        movie7.setGenre("Crime, Drama, Mystery");
        movie7.setRuntime(127);

        User user1 = userRepository.save(new User("Jens", UserRole.REVIEWER));
        User user2 = userRepository.save(new User("Alois", UserRole.ADMIN));

        Review review1 = reviewRepository.save(new Review("Geiler Film"));

        movie1.addReview(review1);
        user1.addReview(review1);
        
        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3,movie4,movie5,movie6,movie7));
        userRepository.saveAll(Arrays.asList(user1, user2));

    }
}