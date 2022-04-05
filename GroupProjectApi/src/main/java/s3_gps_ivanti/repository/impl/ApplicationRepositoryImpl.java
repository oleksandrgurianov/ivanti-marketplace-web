package s3_gps_ivanti.repository.impl;


import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.DataBaseForNow;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.ArrayList;

@Primary
@Service
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private DataBaseForNow database = new DataBaseForNow();

    //all
    @Override
    public ArrayList<Application> getApplicationsSorted(boolean rating, boolean date){ return null; }
    @Override
    public ArrayList<Application> getApplicationsBySearch(String search){ return null; }
    @Override
    public  Application getApplicationsByID(long id){ return null; }
    @Override
    public  ArrayList<Application> getApplicationDetails(String appName){ return null; }

    //Creator
    @Override
    public  ArrayList<Application> getApplicationsByCreator(String ID){ return null; }
    @Override
    public    boolean createApplications(Application app){
        database.applications.add(app);
        return true; }
    @Override
    public  boolean updateApplications(Application app){
        return true;
    }
    @Override
    public boolean deleteApplications(int appID){ return true; }
    @Override
    public  boolean FindAppWithSameName(String appName){
        for(Application a : database.applications)
        {
            if(a.getName().equals(appName))
            {
                return true;
            }
        }
        return false;
    }

    //Customers
    @Override
    public ArrayList<Application> getApplicationsByCustomer(String ID){ return null; }
    @Override
   public File downloadApplications(int appID){ return null; }
}
