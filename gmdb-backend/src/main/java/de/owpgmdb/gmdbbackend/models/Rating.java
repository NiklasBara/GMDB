package de.owpgmdb.gmdbbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Rating {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private int score;
    
}