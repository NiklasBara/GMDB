package de.owpgmdb.gmdbbackend.models.dtos;

import java.util.Set;

import de.owpgmdb.gmdbbackend.models.Review;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * MovieDTO
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MovieDTO {

    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private Long releaseYear;

    private Double averageRating;
    private Set<Review> reviews;

    
}