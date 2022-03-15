package com.example.Individual_Project.business;

import com.example.Individual_Project.model.Application;
import com.example.Individual_Project.model.User;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationService {

    ArrayList<Application> getApplicationsSorted( boolean rating, boolean date);

    ArrayList<Application> getApplicationsBySearch(String search);

    ArrayList<Application> getApplications();

    boolean createApplications( Application app);

    boolean updateApplications(Application app, User user);

    boolean deleteApplications( int appID, User user);

    File downloadApplications(String username, String password, int appID);

    public ArrayList<Application> getAllOfAUsersAppointments(User user);
}
