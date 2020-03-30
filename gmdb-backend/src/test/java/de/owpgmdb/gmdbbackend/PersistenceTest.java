package de.owpgmdb.gmdbbackend;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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

    
}