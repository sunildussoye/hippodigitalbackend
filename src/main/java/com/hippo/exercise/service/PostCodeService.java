package com.hippo.exercise.service;

import com.hippo.exercise.exception.ResultException;
import com.hippo.exercise.model.PostCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class PostCodeService {

    private static final Logger log = LoggerFactory.getLogger(PostCodeService.class);
    private static final String BASE = "https://api.postcodes.io/postcodes/";

    @Autowired
    private RestTemplate restTemplate;

    public PostCode getPostCode(String postCode) {

        String url = String.format("%s%s", BASE, postCode);

        try {
            PostCode response = restTemplate.getForObject(url, PostCode.class);
            return response;
        } catch (HttpStatusCodeException ex) {
            throw new ResultException("Invalid post Code  or Not found");
        }
    }
}
