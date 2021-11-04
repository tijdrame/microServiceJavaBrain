package com.emard.moviecatalogservice.services;

import java.util.Arrays;

import com.emard.moviecatalogservice.models.Rating;
import com.emard.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {
    
    private  final RestTemplate restTemplate;

    public MovieInfoService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallBackUserRating")
    public UserRating getUserRating(String userId){
        return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
    }

    

    public UserRating getFallBackUserRating(String userId){
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRatings(Arrays.asList(new Rating("0",0)));
        return  userRating;

    }

}
