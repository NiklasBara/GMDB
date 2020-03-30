package de.owpgmdb.gmdbbackend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 */
@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private UserRole role;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rating> ratings;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

    public User(String username, UserRole role) {
        this.username = username;
        this.role = role;
    }
    
}