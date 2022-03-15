package com.example.Individual_Project.business;

import com.example.Individual_Project.model.Response;
import com.example.Individual_Project.model.User;

import java.util.ArrayList;

public interface ResponseService {

    ArrayList<Response> getResponse( int reviewID);

    boolean createResponse( int reviewID, Response response, User user);

    boolean updateResponse( Response response, User user);

    boolean deleteResponse( int responseID, User user);

    public ArrayList<Response> getAllOfAUsersResponses(User user);
}
