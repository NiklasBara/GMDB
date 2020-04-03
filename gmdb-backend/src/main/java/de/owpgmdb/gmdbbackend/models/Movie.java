package de.owpgmdb.gmdbbackend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"reviews", "ratings"})
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Movie implements Reviewable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private Long releaseYear;
    private String genre;
    private int runtime;
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("movie")
    private Set<Rating> ratings = new HashSet<>();
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("movie")
    private Set<Review> reviews = new HashSet<>();

    public Movie(String title, Long releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    @Override
    public void addReview(Review review) {
        this.reviews.add(review);
        review.setMovie(this);
    }

    @Override
    public void removeReview(Review review) {
        this.reviews.remove(review);
        review.setMovie(null);
    }

}