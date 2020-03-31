package de.owpgmdb.gmdbbackend;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.hibernate.action.internal.CollectionAction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import de.owpgmdb.gmdbbackend.models.Movie;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;

/**
 * PersistenceTest
 */
@DataJpaTest
public class PersistenceTest {

    @Autowired
    MovieRepository movieRepo;

    @Test
    void dependenciesAreNotNull(){
        Assertions.assertThat(this.movieRepo).isNotNull();
    }

    @Test
    void movieRepoIsEmptyWhenNothingIsAdded(){
        //S SETUP
        List<Movie> expected = Collections.emptyList();
        //E Excersise
        List<Movie> actual = this.movieRepo.findAll();
        //A Assert
        Assertions.assertThat(actual).isEqualTo(expected);
        //(T Teardown)
    }

    @Test
    void canAddMoviesToMovieRepo(){
        Movie newMovie = new Movie("Parasite", 2019L);

        this.movieRepo.save(newMovie);

        List<Movie> actualMovies = this.movieRepo.findAll();

        Assertions.assertThat(actualMovies).hasSize(1);
        Assertions.assertThat(actualMovies.get(0)).isEqualTo(newMovie);

    }

    // @Test
    // void canDeleteMoviesFromMovieRepo(){
    //     Movie newMovie = new Movie("Parasite", 2019L);
    //     List<Movie> expected = Collections.emptyList();

    //     this.movieRepo.save(newMovie);
    //    // this.movieRepo.deleteById(newMovie.getId());
    //     List<Movie> actual = this.movieRepo.findAll();
        
    //     Assertions.assertThat(actual).isEqualTo(expected);

       
    // }

    
}