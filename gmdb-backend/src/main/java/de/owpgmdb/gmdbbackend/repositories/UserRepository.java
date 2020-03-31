package de.owpgmdb.gmdbbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.owpgmdb.gmdbbackend.models.User;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);

}