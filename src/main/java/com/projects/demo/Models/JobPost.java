package com.projects.demo.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class JobPost {
@Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;

    @ElementCollection // List<String> needs this for JPA
    private List<String> postTechStack;

    @OneToOne(cascade = CascadeType.ALL) // will save JobRating along with JobPost
    private JobRating jobRating;

}
