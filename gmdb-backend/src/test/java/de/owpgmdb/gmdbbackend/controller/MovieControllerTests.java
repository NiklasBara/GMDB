package de.owpgmdb.gmdbbackend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import de.owpgmdb.gmdbbackend.controllers.MovieController;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;
/**
 * MovieControllerTests
 */
@WebMvcTest(MovieController.class)
public class MovieControllerTests {

    @Autowired
    @MockBean
    MovieRepository movieRepository;

    @Autowired
	private MockMvc mvc;


    //      private Long id;
    //      private String title;
    //      private Long releaseYear;
    //      private List<Rating> ratings;
    //      private List<Review> reviews;
    private String jsonReturn = "
    [
        {
            { \"id\": 1},
            { \"title\": \"Alice im Wunderland\"},
            { \"releaseYear\": 2020},
        },
        {
            { \"id\": 2},
            { \"title\": \"Alice im Wunderland2\"},
            { \"releaseYear\": 2022},
        }
        ]
    ";    
        
    @Test
    void canGetAllMoviesFromDataBase() throws Exception {""

      
       // when(listMock.add(anyString())).thenReturn(false);
 
        
        given(this.movieRepository.findAll()).willReturn(jsonReturn);
        
        mvc.perform(get("/api/movies"))
            .andExpect(status().isOk())
			.andExpect(jsonPath("$.movies").isArray())
            .andExpect(jsonPath("$.movies", hasSize(2)))
            .andExpect(jsonPath("$.movies[0].id", is(1)));
    }
    
}