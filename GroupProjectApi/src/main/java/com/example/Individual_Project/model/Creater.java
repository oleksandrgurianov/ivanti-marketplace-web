package com.example.Individual_Project.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class Creater extends User{

    private ArrayList<Application> MyApplications;
    private ArrayList<Response> MyResponses;



    public Creater(String username, String password) {
        super(username, password);

        MyApplications = new ArrayList<Application>();
        MyResponses = new ArrayList<Response>();

    }
}
