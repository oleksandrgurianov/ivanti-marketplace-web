package com.example.S3_GPS_Ivanti.repository.Impl;

import com.example.S3_GPS_Ivanti.model.Response;
import com.example.S3_GPS_Ivanti.model.User;
import com.example.S3_GPS_Ivanti.repository.DataBaseForNow;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Primary
@Service
public class ResponseRepositoryImpl implements ResponseRepository {
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
