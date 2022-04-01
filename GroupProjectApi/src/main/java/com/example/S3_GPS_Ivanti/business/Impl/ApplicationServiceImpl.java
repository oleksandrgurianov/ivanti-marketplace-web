package com.example.S3_GPS_Ivanti.business.Impl;

import com.example.S3_GPS_Ivanti.model.*;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public ArrayList<Application> getApplicationsSorted(boolean rating, boolean date) {
        return applicationRepository.getApplicationsSorted(rating, date);
    }

    @Override
    public ArrayList<Application> getApplicationsBySearch(String search) {
        return applicationRepository.getApplicationsBySearch(search);
    }

    @Override
    public Application getApplicationsByID(long ID)
    {
       return applicationRepository.getApplicationsByID(ID);
    }


    @Override
    public ArrayList<Application> getApplications() {
        return applicationRepository.getApplications();
    }

    @Override
    public boolean createApplications( Application app) {
        return applicationRepository.createApplications(app);
    }

    @Override
    public boolean updateApplications(Application app, User user) {

        for(Application a : getAllOfAUsersAppointments(user)) {
            if(a.getId() == app.getId()) {
                return applicationRepository.updateApplications(app);
            }
        }
        return false;
    }

    @Override
    public boolean deleteApplications(int appID, User user) {
        for(Application a : getAllOfAUsersAppointments(user)) {
            if(a.getId() == appID) {
                return applicationRepository.deleteApplications(appID);
            }
        }
        return false;
    }

    @Override
    public File downloadApplications(String username, String password, int appID) {
        return null;
    }

    @Override
    public ArrayList<Application> getAllOfAUsersAppointments(User user) {
        return applicationRepository.getAllOfAUsersAppointments(user);
    }
}
