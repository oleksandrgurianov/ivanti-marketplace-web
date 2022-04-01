package com.example.S3_GPS_Ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Review {
    private int id;
    private ArrayList<Response> responses;
    private Customer customer;
}
