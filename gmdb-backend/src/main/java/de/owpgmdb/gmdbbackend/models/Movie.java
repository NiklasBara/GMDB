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

@Entity
@NoArgsConstructor
@Data
public class Movie {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String title;
    private Long releaseYear;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rating> ratings;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

    public Movie(String title, Long releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

}