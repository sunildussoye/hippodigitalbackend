package com.hippo.exercise.converter;

import com.hippo.exercise.model.ConvertedResponse;
import com.hippo.exercise.model.Response;

public class ConvertResult {

    public static ConvertedResponse Convert(Response response, int sequence) {
        ConvertedResponse convertResponse = new ConvertedResponse();
        convertResponse.setId(sequence);
        convertResponse.setCrimeCategory(response.getCategory());
        convertResponse.setForceResponsible(response.getLocationType().equals("BTB") ? "British Transport Police" : "Normal Police");
        convertResponse.setLocationName(response.getLocation().getStreet().getName());
        convertResponse.setCrimeContext(response.getContext().isEmpty() ? "N/A" : response.getContext());
        convertResponse.setDateOfCrime(response.getMonth());
        return convertResponse;
    }
}


