package io.roshansjava.ratingsdataservice.controllers;

import io.roshansjava.ratingsdataservice.models.Rating;
import io.roshansjava.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/ratingsdata")

public class RatingResource {


    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable ("movieId") String movieId) {
        return new Rating(movieId, 4.5);
    }
        @GetMapping("/users/{userId}")
        public  UserRating getUserRating(@PathVariable ("userId") String userId) {
       List<Rating> ratings=Arrays.asList(
                    new Rating("xirr",4.5),
                    new Rating("bableu",5)
            );
//
            UserRating userRating=new UserRating();
            userRating.setUserRating(ratings);
            return userRating;
        }
    }

