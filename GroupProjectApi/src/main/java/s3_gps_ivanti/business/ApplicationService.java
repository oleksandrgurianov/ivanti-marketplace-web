package s3_gps_ivanti.business;

import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.DTO.ApplicationDetailedInfoDTO;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;
import s3_gps_ivanti.model.Application;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationService {

    //all
    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);
    ArrayList<Application> getApplicationsBySearch(String search);
    ApplicationDetailedInfoDTO getApplicationInfoByID(int id);
    ArrayList<Application> getApplicationDetails(String appName);
    ArrayList<Application> getApplications();

    //Creator
    UpdateApplicationDTO getApplicationToUpdate(String appname);
    boolean createApplications( AddApplicationDTO app);
    boolean updateApplications(UpdateApplicationDTO app);
    boolean deleteApplications(int id);

    ArrayList<Application> getApplicationsByCustomer(int id);
    File downloadApplications(int id);

    ArrayList<Application> getApplicationsByCreator(int id);

    ApplicationDetailedInfoDTO getApplicationInfoByName(String name);

}
