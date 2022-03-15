package com.example.Individual_Project.repository;

import com.example.Individual_Project.model.Response;
import com.example.Individual_Project.model.Review;
import com.example.Individual_Project.model.User;

import java.util.ArrayList;

public interface ResponseRepository {

    ArrayList<Response> getResponse(int reviewID);

    boolean createResponse(int reviewID, Response response);

    boolean updateResponse(Response response);

    boolean deleteResponse(int responseID);

    public ArrayList<Response> getAllOfAUsersResponses(User user);
}
