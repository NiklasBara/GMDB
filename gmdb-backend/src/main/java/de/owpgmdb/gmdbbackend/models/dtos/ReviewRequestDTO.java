package de.owpgmdb.gmdbbackend.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * ReviewDTO
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ReviewRequestDTO {

    private Long userId;
    private Long movieId;
    private String text;
    
}