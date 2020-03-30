package de.owpgmdb.gmdbbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.owpgmdb.gmdbbackend.models.Movie;

/**
 * MovieRepository
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{

    
}