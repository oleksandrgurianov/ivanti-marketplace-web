package com.example.S3_GPS_Ivanti.model;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Creator extends User{

    private ArrayList<Application> MyApplications;
    private ArrayList<Response> MyResponses;
}