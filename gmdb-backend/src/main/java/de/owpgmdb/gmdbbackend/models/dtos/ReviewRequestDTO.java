package de.owpgmdb.gmdbbackend.models.dtos;

import java.util.Set;

import de.owpgmdb.gmdbbackend.models.Review;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
/**
 * ReviewDTO
 */
@Data
@NoArgsConstructor
public class ReviewRequestDTO {

    private Long userId;
    private Long movieId;
    private String text;
    
}