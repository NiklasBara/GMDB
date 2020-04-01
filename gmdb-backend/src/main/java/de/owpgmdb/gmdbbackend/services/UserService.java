package de.owpgmdb.gmdbbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


	public void loginByUsername(String userName) {
		throw new IllegalArgumentException("Username is less than 3 chars");
	}

    
}