package com.hippo.exercise.controller;

import com.hippo.exercise.converter.ConvertResult;
import com.hippo.exercise.model.ConvertedResponse;
import com.hippo.exercise.model.PostCode;
import com.hippo.exercise.model.Response;
import com.hippo.exercise.service.CrimeByPostCodeService;
import com.hippo.exercise.service.PostCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostCodeController {

    @Autowired
    private PostCodeService postCodeService;

    @Autowired
    private CrimeByPostCodeService crimeByPostCodeService;

    @GetMapping("/{postcode}")
    public PostCode getPostCode(@PathVariable String postcode) {

        return postCodeService.getPostCode(postcode);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/crimebypostcode/{postcode}")
    public List<ConvertedResponse> getCrimeRateByPostCode(@PathVariable String postcode) {

        int seq = 0;
        PostCode postCode = postCodeService.getPostCode(postcode);

        Response[] responses = crimeByPostCodeService.getCrimeRate(postCode.getResult().getLatitude(),
                postCode.getResult().getLongitude());

        List<ConvertedResponse> convertedResponses = new ArrayList<>();
        for (Response r : responses) {
            seq++;
            ConvertedResponse convertedResponse = ConvertResult.Convert(r,seq);
            convertedResponses.add(convertedResponse);
        }
        return convertedResponses;
    }
}


