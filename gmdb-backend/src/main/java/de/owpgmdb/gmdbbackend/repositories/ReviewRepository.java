package de.owpgmdb.gmdbbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import de.owpgmdb.gmdbbackend.models.Review;

/**
 * MovieRepository
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{
    
    
}