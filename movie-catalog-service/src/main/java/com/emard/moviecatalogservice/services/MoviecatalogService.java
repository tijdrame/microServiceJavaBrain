package com.emard.moviecatalogservice.services;

import com.emard.moviecatalogservice.models.CatalogItem;
import com.emard.moviecatalogservice.models.Movie;
import com.emard.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MoviecatalogService {
    
    private  final RestTemplate restTemplate;

    public MoviecatalogService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @HystrixCommand(fallbackMethod = "getFallBackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    public CatalogItem getFallBackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "", rating.getRating());
    }
}
