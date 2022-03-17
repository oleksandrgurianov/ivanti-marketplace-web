package com.example.S3_GPS_Ivanti.repository;

import com.example.S3_GPS_Ivanti.model.Application;
import com.example.S3_GPS_Ivanti.model.User;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationRepository {

    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);

    ArrayList<Application> getApplicationsBySearch(String search);

    ArrayList<Application> getApplications();

    boolean createApplications(Application app);

    boolean updateApplications(Application app);

    boolean deleteApplications(int appID);

    File downloadApplications(int appID);

    public ArrayList<Application> getAllOfAUsersAppointments(User user);
}
