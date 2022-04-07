package s3_gps_ivanti.repository;

import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.model.Application;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationRepository {

    //all
    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);
    ArrayList<Application> getApplicationsBySearch(String search);
    Application getApplicationsByID(long id);
    ArrayList<Application> getApplicationDetails(String appName);

    //Creator
    ArrayList<Application> getApplicationsByCreator(String ID);
    boolean createApplications(Application app);
    boolean updateApplications(Application app);
    boolean deleteApplications(int appID);
    boolean FindAppWithSameName(String appName);

    //Customers
    ArrayList<Application> getApplicationsByCustomer(String ID);
    File downloadApplications(int appID);
}
