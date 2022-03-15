package com.example.Individual_Project.model;

import lombok.*;

import java.security.KeyStore;
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
