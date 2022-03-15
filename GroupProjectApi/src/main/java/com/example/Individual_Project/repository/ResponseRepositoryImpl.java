package com.example.Individual_Project.repository;

import com.example.Individual_Project.model.Response;
import com.example.Individual_Project.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Primary
@Service
public class ResponseRepositoryImpl implements ResponseRepository{
    private DataBaseForNow database;

    @Override
    public ArrayList<Response> getResponse(int reviewID) {
        return null;
    }

    @Override
    public boolean createResponse(int reviewID, Response response) {
        return false;
    }

    @Override
    public boolean updateResponse(Response response) {
        return false;
    }

    @Override
    public boolean deleteResponse(int responseID) {
        return false;
    }

    public ArrayList<Response> getAllOfAUsersResponses(User user) {return null;}
}
