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

@Entity
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class Rating {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NonNull
    private Integer score;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties({"reviews", "ratings"})
    private Movie movie;
    
    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"reviews", "ratings"})
    private User user;

    public Rating(int score) {
        this.score = score;
    }

    
    
}