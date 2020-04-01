package de.owpgmdb.gmdbbackend.controller;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import de.owpgmdb.gmdbbackend.controllers.UserController;
import de.owpgmdb.gmdbbackend.models.Rating;
import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.models.UserRole;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

import static org.assertj.core.api.Assertions.*;

/**
 * UserControllerTests
 */

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @MockBean
    UserRepository userRepository;


    @Autowired
    UserRepository userReal;

    @Autowired
    private MockMvc mvc;

    @Autowired
	ObjectMapper objectMapper;
    
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

        mvc.perform(get("/api/user/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.reviews").isArray())
            .andExpect(jsonPath("$.reviews", hasSize(2)))
            .andExpect(jsonPath("$.ratings").isArray())
            .andExpect(jsonPath("$.ratings", hasSize(2)))
            .andExpect(jsonPath("$.username", is("Marc Jaber")))
            .andExpect(jsonPath("$.role", is("REVIEWER")));
    }

    @Test
    void canInsertUserIntoDBWhenUsernameNotYetUsed() throws Exception {
        User user = new User("Marc Jaber", UserRole.REVIEWER);
        User returnUser = new User("Marc Jaber", UserRole.REVIEWER);
        returnUser.setId(1L);

        when(this.userRepository.save(user)).thenReturn(returnUser);

        assertThat(user.getId()).isNull();

        this.mvc.perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(asJsonString(user)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username", is("Marc Jaber")))
            .andExpect(jsonPath("$.id", is(1)));
    }

    private void repeatPostRequest(User user) throws Exception {
        this.mvc.perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(asJsonString(user))); 
    }

    @Test
    void canNotInsertUserIntoDBWhenUserNameAlreadyInUse() throws Exception {
        User user = new User("Marc Jaber", UserRole.REVIEWER);
        User user2 = new User("Marc Jaber", UserRole.ADMIN);

        User returnUser = new User("Marc Jaber", UserRole.REVIEWER);
        returnUser.setId(1L);

        when(this.userRepository.save(user)).thenReturn(returnUser);
        this.mvc.perform(post("/api/user")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(asJsonString(user)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username", is("Marc Jaber")))
            .andExpect(jsonPath("$.id", is(1)));
   
        when(this.userRepository.findByUsername(user2.getUsername())).thenReturn(Optional.of(returnUser));

        assertThatThrownBy(() -> repeatPostRequest(user2))
            .isExactlyInstanceOf(NestedServletException.class)
            .hasCauseExactlyInstanceOf(ConstraintViolationException.class)
            .hasMessageContaining("Cannot add multiple Users with same username");
           
    }
        
    private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}