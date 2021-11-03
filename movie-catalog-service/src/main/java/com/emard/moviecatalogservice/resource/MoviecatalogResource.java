package com.emard.moviecatalogservice.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.emard.moviecatalogservice.models.CatalogItem;
import com.emard.moviecatalogservice.models.Movie;
import com.emard.moviecatalogservice.models.Rating;
import com.emard.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class MoviecatalogResource {

    private  final RestTemplate restTemplate;
    //private  final WebClient.Builder webClient;
    //private  final DiscoveryClient discoveryClient;

    public MoviecatalogResource(RestTemplate restTemplate/*, WebClient.Builder webClient, DiscoveryClient discoveryClient*/){
        this.restTemplate = restTemplate;
        //this.webClient = webClient;
        //this.discoveryClient = discoveryClient;
    }    

    /*private Movie getWebClient(String url, String movieId) {
        return webClient.build()
        .get()
        .uri(url+movieId)
        .retrieve()
        .bodyToMono(Movie.class)
        .block();
    }*/
    
    @GetMapping("/{userId}")
    @HystrixCommand(fallbackMethod = "getFallBackCatalog"  )
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId){
        //List<ServiceInstance> instances = discoveryClient.getInstances("serviceId");
        List<CatalogItem> catalogItems =  new ArrayList<>();
        // RestTemplate restTemplate = new RestTemplate();

        //get all rated movie IDs
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
        List<Rating> ratings = userRating.getRatings();

        //for each movie ID, call movie info service and get details
        for (Rating rating : ratings) {
            Movie movie =  restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
            //Movie movie =  getWebClient("http://localhost:8081/movies/", rating.getMovieId());
            catalogItems.add(new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating()));
        }
        return catalogItems;
        /*return ratings.stream().map(rating -> {
        Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);

            new CatalogItem(movie.getName(), "Desc", rating.getRating());
        })
        .collect(Collectors.toList());

        // put them all together

        /*return Collections.singletonList(
            new CatalogItem("Transformers", "Test", 4)
            );*/
    }

    public List<CatalogItem> getFallBackCatalog(@PathVariable("userId") String userId){
        return Arrays.asList(new CatalogItem("No movie", "", 0));
    }
}
