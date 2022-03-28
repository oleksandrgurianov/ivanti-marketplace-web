package com.example.S3_GPS_Ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class Review {

    private int id;
    private ArrayList<Response> responses;
    private Customer customer;

    public Review(int id, Customer customer){
        this.id = id;
        this.customer = customer;
        this.responses = new ArrayList<>();
    }
}
