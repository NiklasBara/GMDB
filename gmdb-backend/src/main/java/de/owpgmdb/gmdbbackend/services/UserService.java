package de.owpgmdb.gmdbbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User loginByUsername(String username) {
        checkUsername(username);
        return userRepo.findByUsername(username).get();
    }

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