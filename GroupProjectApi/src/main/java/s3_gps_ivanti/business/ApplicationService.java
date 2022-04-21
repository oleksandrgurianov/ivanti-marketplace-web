package s3_gps_ivanti.business;

import s3_gps_ivanti.DTO.ApplicationDetailedInfoDTO;
import s3_gps_ivanti.model.Application;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationService {

    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);

    ArrayList<Application> getApplicationsBySearch(String search);

    Application getApplicationsByID(long id);

    ArrayList<Application> getApplications();

    boolean createApplications( Application app);

    boolean updateApplications(Application app);

    boolean deleteApplications( int appID);

    File downloadApplications(int appID);

    ArrayList<Application> getApplicationsByCreator(int id);

    ApplicationDetailedInfoDTO getApplicationInfoByName(String name);

}
