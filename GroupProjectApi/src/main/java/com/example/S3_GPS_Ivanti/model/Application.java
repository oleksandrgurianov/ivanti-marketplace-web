package com.example.S3_GPS_Ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private int id;
    private Creater creater;
    private ArrayList<Review> reviews;

}
