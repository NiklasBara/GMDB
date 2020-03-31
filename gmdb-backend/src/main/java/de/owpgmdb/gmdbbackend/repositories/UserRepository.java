package de.owpgmdb.gmdbbackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.owpgmdb.gmdbbackend.models.User;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    /**
     * Returns an Optional representing the found User. 
     * @param username - The Username that will be searched for.
     * @return An Optional that has an User if one is found or an empty Optional if no User with that name was found.
     */
    Optional<User> findByUsername(String username);

}