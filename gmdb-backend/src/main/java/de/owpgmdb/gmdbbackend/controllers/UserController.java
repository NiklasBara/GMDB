package de.owpgmdb.gmdbbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * UserController
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    
}