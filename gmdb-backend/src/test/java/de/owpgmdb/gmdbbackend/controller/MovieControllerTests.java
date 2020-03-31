package de.owpgmdb.gmdbbackend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import de.owpgmdb.gmdbbackend.controllers.MovieController;
import de.owpgmdb.gmdbbackend.models.Movie;
import de.owpgmdb.gmdbbackend.models.Rating;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;


import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
/**
 * MovieControllerTests
 */
@WebMvcTest(MovieController.class)
public class MovieControllerTests {

    
    @MockBean
    MovieRepository movieRepository;

    @Autowired
	private MockMvc mvc;


        
    @Test
    void canGetAllMoviesFromDataBase() throws Exception {
        List<Movie> returnList = new ArrayList<>();
        returnList.add(new Movie("Alice im Wunderland", 2020L));
        returnList.add(new Movie("Alice im Wunderland2", 2022L));
        
        when(this.movieRepository.findAll()).thenReturn(returnList);
   

        mvc.perform(get("/movies"))
            .andExpect(status().isOk())
			.andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].title", is("Alice im Wunderland")))    
            .andExpect(jsonPath("$[0].releaseYear", is(2020))) 
            .andExpect(jsonPath("$[1].title", is("Alice im Wunderland2")))     
            .andExpect(jsonPath("$[1].releaseYear", is(2022)));     
    }

    @Test
    void canGetAverageRatingOfMoviesFromDatabase() throws Exception {
        Movie movie = new Movie("Test", 2019L);
        movie.setRatings(new HashSet<>());
        Rating rating1 = new Rating();
        rating1.setScore(5);
        Rating rating2 = new Rating();
        rating2.setScore(4);
        Rating rating3 = new Rating();
        rating3.setScore(3);
        Rating rating4 = new Rating();
        rating4.setScore(2);

        movie.getRatings().addAll(Arrays.asList(rating1,rating2,rating3,rating4));
        List<Movie> returnList = new ArrayList<>();
        returnList.add(movie);
    }   
}