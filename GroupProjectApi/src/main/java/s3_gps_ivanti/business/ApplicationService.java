package s3_gps_ivanti.business;

import s3_gps_ivanti.dto.*;
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
    ArrayList<ApplicationStatisticsDTO> getApplicationStatisticsDTO(ArrayList<Application> applications);

    //Creator
    UpdateApplicationDTO getApplicationToUpdate(String appname);
    CreateApplicationResponseDTO createApplications(CreateApplicationRequestDTO app);
    boolean updateApplications(UpdateApplicationDTO app);
    boolean deleteApplications(String name);

    ArrayList<Application> getApplicationsByCustomer(int id);
    File downloadApplications(int id);

    ArrayList<Application> getApplicationsByCreator(int id);

    ApplicationDetailedInfoDTO getApplicationInfoByName(String name);

}
