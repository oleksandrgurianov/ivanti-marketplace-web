package com.example.S3_GPS_Ivanti.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Application {

    private int id;
    private Creator creater;
    private ArrayList<Review> reviews;

}
