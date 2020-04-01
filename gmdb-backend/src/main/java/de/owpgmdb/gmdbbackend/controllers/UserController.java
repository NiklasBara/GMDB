package de.owpgmdb.gmdbbackend.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * UserController
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
       return userRepository.getOne(id);
    }


    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ConstraintViolationException("Cannot add multiple Users with same username", null, null);
        } 
        return userRepository.save(user);
    }

    
}