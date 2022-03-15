package com.example.Individual_Project.repository;

import com.example.Individual_Project.model.Application;
import com.example.Individual_Project.model.Review;
import com.example.Individual_Project.model.User;

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
