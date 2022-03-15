package com.example.Individual_Project.model;

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
    private Creater creater;
    private ArrayList<Review> reviews;

}
