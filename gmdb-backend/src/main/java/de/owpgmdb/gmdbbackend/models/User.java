package de.owpgmdb.gmdbbackend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * User
 */
@Data
@NoArgsConstructor
@Table(name = "user_account")
@Entity
@EqualsAndHashCode(exclude = { "reviews", "ratings" })
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Reviewable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)

    @JsonIgnoreProperties("user")
    private Set<Rating> ratings = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)

    @JsonIgnoreProperties("user")
    private Set<Review> reviews = new HashSet<>();

    public User(String username, UserRole role) {
        this.username = username;
        this.role = role;
    }

    @Override
    public void addReview(Review review) {
        this.reviews.add(review);
        review.setUser(this);
    }

    @Override
    public void removeReview(Review review) {
        this.reviews.remove(review);
        review.setUser(null);
    }

}