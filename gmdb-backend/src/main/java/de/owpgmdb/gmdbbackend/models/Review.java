package de.owpgmdb.gmdbbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Review
 */
@NoArgsConstructor
@Data
@Entity
@RequiredArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String text;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties({"reviews", "ratings"})
    @ToString.Exclude
    private Movie movie;
    
    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"reviews", "ratings"})
    @ToString.Exclude
    private User user;

    //tbd remove?
    public Review(String text) {
        this.text = text;
    }

    

}