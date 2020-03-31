package de.owpgmdb.gmdbbackend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
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
            .andExpect(jsonPath("$[0].title", is("Alice im Wunderland")));     
    }
    
}