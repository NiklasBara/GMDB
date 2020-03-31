package de.owpgmdb.gmdbbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import de.owpgmdb.gmdbbackend.controllers.UserController;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * UserControllerTests
 */

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @MockBean
    UserRepository userRepository;

    @Autowired
    private MockMvc mvc;
    
    @Test
    void canGetSingleUserFromDatabaseIncludingAllInformationAndReviews() throws Exception{
        

        // Movie movie = new Movie("Alice im Wunderland", 2020L);
        // movie.setId(1L);
        // movie.getReviews().add(new Review("Super Film"));
        // movie.getReviews().add(new Review("Super Toller Film"));
        
        // when(this.movieRepository.getOne(movie.getId())).thenReturn(movie);

        // mvc.perform(get("/movies/1"))
        //     .andExpect(status().isOk())
        //     .andExpect(jsonPath("$.id", is(1)))
        //     .andExpect(jsonPath("$.averageRating", is(-1.0)))
        //     .andExpect(jsonPath("$.reviews").isArray())
        //     .andExpect(jsonPath("$.reviews", hasSize(2)))
        //     .andExpect(jsonPath("$.reviews[*].text", containsInAnyOrder("Super Film","Super Toller Film")));     
    }
}