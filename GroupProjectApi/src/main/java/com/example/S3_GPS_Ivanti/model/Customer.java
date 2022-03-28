package com.example.S3_GPS_Ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer extends User{

    private ArrayList<Review> myReviews;
    private ArrayList<Application> downloadedApplications;
}
