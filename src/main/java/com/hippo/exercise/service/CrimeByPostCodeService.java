package com.hippo.exercise.service;

import com.hippo.exercise.model.Response;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;

@Service
public class CrimeByPostCodeService {

     private static final Logger log = LoggerFactory.getLogger(CrimeByPostCodeService.class);

    @Autowired
    private RestTemplate restTemplate;

    public Response[] getCrimeRate(double lat, double lng) {
       String url = "https://data.police.uk/api/crimes-street/all-crime?lat=" + lat + "&lng=" + lng ;
        ResponseEntity<Response[]> response =
                restTemplate.getForEntity(
                         url ,
                        Response[].class);
        Response[] responses = response.getBody();
       return responses;
    }
}
