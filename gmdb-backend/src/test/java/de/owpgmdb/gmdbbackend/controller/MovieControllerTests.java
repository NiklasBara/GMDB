package de.owpgmdb.gmdbbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import de.owpgmdb.gmdbbackend.controllers.MovieController;

/**
 * MovieControllerTests
 */
@WebMvcTest(MovieController.class)
public class MovieControllerTests {

    @Autowired
    @MockBean
    MovieRepository movieRepository;



    @Test
    void canGetAllMoviesFromDataBase() {

    }
    
}