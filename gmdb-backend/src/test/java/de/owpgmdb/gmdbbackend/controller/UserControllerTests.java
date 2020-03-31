package de.owpgmdb.gmdbbackend.controller;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import de.owpgmdb.gmdbbackend.controllers.UserController;
import de.owpgmdb.gmdbbackend.models.Rating;
import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.models.UserRole;
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
        User user = new User("Marc Jaber", UserRole.REVIEWER);
        user.setId(1L);
        Review review1 = new Review("Mega Film");
        Review review2 = new Review("Klasse Film");
        review1.setId(2L);
        review2.setId(3L);
        Rating rating1 = new Rating(5);
        Rating rating2 = new Rating(4);
        rating1.setId(4L);
        rating2.setId(5L);
        user.getReviews().addAll(Arrays.asList(review1,review2));       
        user.getRatings().addAll(Arrays.asList(rating1,rating2));       
        
        when(this.userRepository.getOne(user.getId())).thenReturn(user);

        mvc.perform(get("/api/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.reviews").isArray())
            .andExpect(jsonPath("$.reviews", hasSize(2)))
            .andExpect(jsonPath("$.ratings").isArray())
            .andExpect(jsonPath("$.ratings", hasSize(2)))
            .andExpect(jsonPath("$.username", is("Marc Jaber")))
            .andExpect(jsonPath("$.role", is("REVIEWER")));
    }
}