package de.owpgmdb.gmdbbackend.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.models.UserRole;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * ReviewServiceTest
 */
@SpringBootTest
public class ReviewServiceTest {

    @MockBean
    private UserRepository userRepo;
    @MockBean
    private MovieRepository movieRepo;
    @Autowired
    private ReviewService service;

    @BeforeEach
    void clearMocks() {
        Mockito.reset(userRepo);
        Mockito.reset(movieRepo);
    }

    @Test
    void dependenicesAreNotNull() {
        Assertions.assertThat(userRepo).isNotNull();
        Assertions.assertThat(movieRepo).isNotNull();
        Assertions.assertThat(service).isNotNull();
    }
    /*
     * N - return - X, params: review -> IllegalArg Z - X O - One - Only one review
     * can be added per user M - X B - X I - Review addReview(userId, movieId,
     * review) E - IllegalArgs bei Null Review / More than one Review S - Simple
     * Cases / IlleagalArg if Movie or User not found
     */

    @Test
    void givenReviewCantBeNull() {
        Exception actual = assertThrows(IllegalArgumentException.class, () -> this.service.addReview(0L, 0L, null));
        Assertions.assertThat(actual).hasMessage("Review must not be null");
    }

    @Test
    void canAddReviewToStoredUser() {


        long userId = 0;
        User user = Mockito.mock(User.class);
        user.setUsername("username");
        user.setRole(UserRole.REVIEWER);
        user.setId(userId);
        when(this.userRepo.findById(userId)).thenReturn(Optional.of(user));
        
        Review review = new Review("Very Good");


        this.service.addReview(userId, 0L, review);

        verify(user).addReview(review);
        verify(this.userRepo).save(user);
    }

    @Test
    void givenUserIdNotFoundThrowsIllegalArgException() {
        long userId = 0;
        when(this.userRepo.findById(userId)).thenReturn(Optional.empty());

        Exception actual = assertThrows(NoSuchElementException.class, () -> this.service.addReview(userId, 0L, new Review()));
        Assertions.assertThat(actual).hasMessage("User not found");
    }
}