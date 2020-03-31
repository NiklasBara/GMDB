package de.owpgmdb.gmdbbackend.models.dtos;

import de.owpgmdb.gmdbbackend.models.Movie;
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

    
}