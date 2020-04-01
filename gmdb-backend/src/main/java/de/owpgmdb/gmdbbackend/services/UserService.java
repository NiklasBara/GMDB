package de.owpgmdb.gmdbbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.owpgmdb.gmdbbackend.models.Login;
import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * UserService
 * It is able to return a User by a Username
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    /**
     * checks username 
     * returns a User from database find by username
     * @param username - username as String
     * @return User from database
     */
    public User loginByUsername(String username) {
        checkUsername(username);

        return userRepo.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Username could not be found"));

    }
    /* public User loginByUsername(Login username) {
        checkUsername(username.getUsername());

        return userRepo.findByUsername(username.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Username could not be found"));

    } */

    /**
     * checks username 
     *  - if 3 < username.lenght < 20
     *  - username != null
     * @param username
     */
    private void checkUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username can not be null");
        } else if (username.length() < 3) {
            throw new IllegalArgumentException("Username is less than 3 chars");
        } else if (username.length() > 20) {
            throw new IllegalArgumentException("Username is more than 20 chars");
        }
    }

}