package de.owpgmdb.gmdbbackend.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
     * N - return - X, params: review -> IllegalArg 
     * Z - X 
     * O - One - Only one review can be added per user
     * M - X B - X I - Review addReview(userId, movieId, review) 
     * E - IllegalArgs bei Null Review / More than one Review 
     * S - Simple Cases
     */

    @Test
    void givenReviewCantBeNull() {
        Exception actual = assertThrows(IllegalArgumentException.class, () -> this.service.addReview(0L, 0L, null));
        Assertions.assertThat(actual).hasMessage("Review must not be null");
    }
}