package com.example.S3_GPS_Ivanti.repository;

import com.example.S3_GPS_Ivanti.model.Response;
import com.example.S3_GPS_Ivanti.model.User;

import java.util.ArrayList;

public interface ResponseRepository {

    ArrayList<Response> getResponse(int reviewID);

    boolean createResponse(int reviewID, Response response);

    boolean updateResponse(Response response);

    boolean deleteResponse(int responseID);

    public ArrayList<Response> getAllOfAUsersResponses(User user);
}