package com.example.S3_GPS_Ivanti.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private int id;

    private Review review;
    private Creater creater;
}
