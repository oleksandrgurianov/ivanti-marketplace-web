package s3_gps_ivanti.repository;

import s3_gps_ivanti.DTO.ApplicationDetailedInfoDTO;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.User;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationRepository  {

    //all
    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);

    ArrayList<Application> getApplicationsBySearch(String search);

    //Creator
    ArrayList<Application> getApplications();
    Application getApplicationsByID(long ID);

    Application getApplicationsByID(int id);
    ArrayList<Application> getApplicationDetails(String appName);
    boolean createApplications(Application app);
    ArrayList<Application> getApplicationsByCreator(int ID);
    boolean updateApplications(Application app);

    boolean deleteApplications(String name);
    boolean FindAppWithSameName(String appName);

    //Customer
    Application getApplicationToUpdate(String appname);
    File downloadApplications(int appID);

    Application getApplicationInfoByName(String name);

    ArrayList<Application> getApplicationsByCustomer(int ID);
}
