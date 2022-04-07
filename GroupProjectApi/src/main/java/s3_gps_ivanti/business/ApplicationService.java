package s3_gps_ivanti.business;

import s3_gps_ivanti.DTO.UpdateApplicationDTO;
import s3_gps_ivanti.model.Application;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationService {

    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);

    ArrayList<Application> getApplicationsBySearch(String search);

    Application getApplicationsByID(String id);

    ArrayList<Application> getApplications();

    boolean createApplications( Application app);

    boolean updateApplications(UpdateApplicationDTO app);

    boolean deleteApplications( String appID);

    UpdateApplicationDTO getApplicationToUpdate(String appname);

    File downloadApplications(String appID);

}
