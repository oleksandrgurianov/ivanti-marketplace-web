package com.example.S3_GPS_Ivanti.repository.Impl;

import com.example.S3_GPS_Ivanti.model.User;
import com.example.S3_GPS_Ivanti.repository.DataBaseForNow;
import com.example.S3_GPS_Ivanti.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private DataBaseForNow database;

    @Override
    public User getUser(String username, String password) {
        return null;
    }
}
