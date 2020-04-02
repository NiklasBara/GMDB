package de.owpgmdb.gmdbbackend.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import de.owpgmdb.gmdbbackend.controllers.ReviewController;
import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.dtos.ReviewRequestDTO;
import de.owpgmdb.gmdbbackend.services.ReviewService;


@WebMvcTest(ReviewController.class)
public class ReviewControllerTests {

    
    @MockBean
    ReviewService reviewService;

    @Autowired
    private MockMvc mvc;

    @Autowired
	ObjectMapper objectMapper;

    //Controller takes JSON { userId: x, movieId: x, review: "text" }
    @Test
    void canAcceptReviewWhenMovieAndUserAreCorrectlyProvided() throws Exception {
        Review review = new Review("Guter Film");
        Long userId = 1L;
        Long movieId = 2L;
        
        ReviewRequestDTO reviewRequestDto = new ReviewRequestDTO();
        reviewRequestDto.setMovieId(movieId);
        reviewRequestDto.setUserId(userId);
        reviewRequestDto.setText(review.getText());

        doNothing().when(this.reviewService).addReview(isA(Long.class), isA(Long.class), isA(Review.class));
           
        mvc.perform(post("/api/review")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(asJsonString(reviewRequestDto)))
            .andExpect(status().isOk());

        verify(this.reviewService, times(1)).addReview(userId, movieId, review);
    }

    //@Test
    void expectErrorWhenReviewToPostHasNoReviewText() throws Exception {
        Review review = new Review();
        Long userId = 1L;
        Long movieId = 2L;

        ReviewRequestDTO reviewRequestDto = new ReviewRequestDTO();
        reviewRequestDto.setMovieId(movieId);
        reviewRequestDto.setUserId(userId);

        doNothing().when(this.reviewService).addReview(isA(Long.class), isA(Long.class), isA(Review.class));

        assertThatThrownBy(() -> { 
            mvc.perform(post("/api/review")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(reviewRequestDto)));
            }).isExactlyInstanceOf(NestedServletException.class);



            // .hasCauseExactlyInstanceOf(ConstraintViolationException.class)
            // .hasMessageContaining("Cannot add multiple Users with same username");


        verify(this.reviewService, times(1)).addReview(userId, movieId, review);

    }

	private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    
}