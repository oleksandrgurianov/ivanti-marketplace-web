package s3_gps_ivanti.repository;

import s3_gps_ivanti.dto.GetVersionDTO;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Version;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface ApplicationRepository  {

    //all
    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);

    ArrayList<Application> getApplicationsBySearch(String search);

    //Creator
    ArrayList<Application> getApplications();

    Application getApplicationsByID(int id);
    ArrayList<Application> getApplicationDetails(String appName);
    boolean createApplications(Application app);
    ArrayList<Application> getApplicationsByCreator(int ID);
    boolean updateApplications(Application app);

    boolean deleteApplications(String name);
    boolean FindAppWithSameName(String appName);

              //Versions
    Version getVersion(int applicationId, Double number);
    boolean createVersion(int applicationId, Version version);
    boolean deleteVerison(int applicationId, Double number);
    Version updateVersion(int applicationId, Version version);
    public List<Version> getVersionsByApplication(String appname);

    //Customer
    Application getApplicationToUpdate(String appname);
    File downloadApplications(int appID);

    Application getApplicationInfoByName(String name);

    ArrayList<Application> getApplicationsByCustomer(int ID);
}
