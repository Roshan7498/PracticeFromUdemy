package com.projects.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class JobRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int r_id;
    private int rating;
    private String behaviour;

    // Custom constructor for rating and behaviour
    public JobRating(int rating, String behaviour) {
        this.rating = rating;
        this.behaviour = behaviour;
    }


}
