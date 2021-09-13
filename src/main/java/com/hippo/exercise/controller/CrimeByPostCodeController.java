package com.hippo.exercise.controller;

import com.hippo.exercise.model.Response;
import com.hippo.exercise.service.CrimeByPostCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrimeByPostCodeController {

    @Autowired
    private CrimeByPostCodeService crimeByPostCodeService;

    @GetMapping("/crime")
    public Response[] getCrimeRate(@RequestParam(name = "lat", required = true) double  lat,
                                   @RequestParam(name = "lng", required = true) double lng) {


        return crimeByPostCodeService.getCrimeRate(lat,lng);
    }


}

