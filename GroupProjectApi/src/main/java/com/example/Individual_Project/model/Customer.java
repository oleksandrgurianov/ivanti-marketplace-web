package com.example.Individual_Project.model;

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
