package io.roshansjava.moviecatalogservice.controllers;

import io.roshansjava.moviecatalogservice.models.CatalogItem;
import io.roshansjava.moviecatalogservice.models.Movie;
import io.roshansjava.moviecatalogservice.models.Rating;
import io.roshansjava.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;


@RestController
@RequestMapping("/catalog")
    public class MovieCatalogResource {

    @Autowired
private WebClient.Builder builder;
//            =WebClient.builder();
    @Autowired
   private RestTemplate restTemplate ;
//    = new RestTemplate();

        @GetMapping("/{userId}")
        public List<CatalogItem> getCatalog(@PathVariable ("userId") String userId){

//We have to get all movieIds first then
// for each movieIds call the info service and fetch their respective details
// finally put them all together
         UserRating ratings=restTemplate.getForObject(
        "http://localhost:8082/ratingsdata/users/"+userId, UserRating.class);
         return ratings.getUserRating().stream().map(rating ->{
          Movie movie= restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);

       return new CatalogItem(movie.getName(), "Suspense", rating.getRating());

//      return Collections.singletonList(new CatalogItem("Titanic","Romantic",5));

        })
          .collect(Collectors.toList());



        }
}





        /*      Movie movie=  builder.build()
             //get ,put,post methods
                  .get()
                  .uri("http://localhost:8081/movies/"+rating.getMovieId())
                  .retrieve()
                  .bodyToMono(Movie.class)
                  .block();

         */