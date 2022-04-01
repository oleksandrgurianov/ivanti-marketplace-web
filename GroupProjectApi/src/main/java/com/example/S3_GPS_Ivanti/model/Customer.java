package com.example.S3_GPS_Ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{

    private ArrayList<Review> myReviews;
    private ArrayList<Application> downloadedApplications;

    public Customer(String username,String password,ArrayList<Review> myReviews, ArrayList<Application> downloadedApplications)
    {
        super(username, password);
        this.myReviews = myReviews;
        this.downloadedApplications = downloadedApplications;
    }
}
