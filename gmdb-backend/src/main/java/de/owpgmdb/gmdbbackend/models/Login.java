package de.owpgmdb.gmdbbackend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Login
 */

@NoArgsConstructor
@Data
public class Login {

    private String username;

    public Login(String username) {
        this.username = username;
    }

}