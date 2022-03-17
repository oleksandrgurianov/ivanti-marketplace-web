package com.example.S3_GPS_Ivanti.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class Customer extends User{

    private ArrayList<Review> myReviews;
    private ArrayList<Application> downloadedApplications;

    public Customer(String username, String password) {
        super(username, password);

        myReviews = new ArrayList<Review>();
        downloadedApplications = new ArrayList<Application>();
    }
}
