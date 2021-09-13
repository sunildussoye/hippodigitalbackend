package com.hippo.exercise.model;

public class ConvertedResponse {
    private int id;
    private String crimeCategory;
    private String forceResponsible;
    private String locationName;
    private String crimeContext;
    private String dateOfCrime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrimeCategory() {
        return crimeCategory;
    }

    public void setCrimeCategory(String crimeCategory) {
        this.crimeCategory = crimeCategory;
    }

    public String getForceResponsible() {
        return forceResponsible;
    }

    public void setForceResponsible(String forceResponsible) {
        this.forceResponsible = forceResponsible;
    }


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCrimeContext() {
        return crimeContext;
    }

    public void setCrimeContext(String crimeContext) {
        this.crimeContext = crimeContext;
    }

    public String getDateOfCrime() {
        return dateOfCrime;
    }

    public void setDateOfCrime(String dateOfCrime) {
        this.dateOfCrime = dateOfCrime;
    }


}
