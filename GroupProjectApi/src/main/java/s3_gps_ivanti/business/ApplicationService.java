package s3_gps_ivanti.business;

import org.springframework.web.bind.annotation.PathVariable;
import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.model.Application;

import java.io.File;
import java.util.ArrayList;

public interface ApplicationService {

    //all
    ArrayList<Application> getApplicationsSorted(boolean rating, boolean date);
    ArrayList<Application> getApplicationsBySearch(String search);
    Application getApplicationsByID(long id);
    ArrayList<Application> getApplicationDetails(String appName);

    //Creator
    ArrayList<Application> getApplicationsByCreator(String ID);
    boolean createApplications( AddApplicationDTO app);
    boolean updateApplications(Application app);
    boolean deleteApplications( int appID);

    //Customers
    ArrayList<Application> getApplicationsByCustomer(String ID);
    File downloadApplications(int appID);

}
