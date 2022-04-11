package s3_gps_ivanti.business;

import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;
import s3_gps_ivanti.model.Application;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationService {

    //all
    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);
    ArrayList<Application> getApplicationsBySearch(String search);
    Application getApplicationsByID(String id);
    ArrayList<Application> getApplicationDetails(String appName);
    ArrayList<Application> getApplications();

    //Creator
    ArrayList<Application> getApplicationsByCreator(String ID);
    UpdateApplicationDTO getApplicationToUpdate(String appname);
    boolean createApplications( AddApplicationDTO app);
    boolean updateApplications(UpdateApplicationDTO app);
    boolean deleteApplications( String appID);

    ArrayList<Application> getApplicationsByCustomer(String ID);
    File downloadApplications(String appID);

}
