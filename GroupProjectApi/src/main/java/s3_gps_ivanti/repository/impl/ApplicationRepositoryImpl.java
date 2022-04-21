package s3_gps_ivanti.repository.impl;


import s3_gps_ivanti.DTO.ApplicationDetailedInfoDTO;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.model.Review;
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
    public ArrayList<Application> getApplicationsSorted(boolean rating, boolean date) {
        return new ArrayList<Application>();
    }
    @Override
    public ArrayList<Application> getApplicationsBySearch(String search) {
        return new ArrayList<Application>();
    }

    @Override
    public Application getApplicationsByID(int id) {
        for(Application app : database.applications) {
            if (app.getId() == id) {
                return app;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Application> getApplications() {
        return null;
    }

    //Creator
    @Override
    public ArrayList<Application> getApplicationDetails(String appName){
        ArrayList<Application> apps = new ArrayList<>();

        for (Application a : database.applications) {
            if(a.getName().equals(appName)) {
                apps.add(a);
            }
        }
        return apps;
    }
    @Override
    public boolean createApplications(Application app){
        database.applications.add(app);
        return true;
    }
    @Override
    public  ArrayList<Application> getApplicationsByCreator(int id){ return null; }
    @Override
    public boolean updateApplications(Application app) {
        for(Application a : database.applications)
        {
            if(a.getId() == app.getId()){
                a.setName(app.getName());
                a.setDescription(app.getDescription());
                a.setScreenshots(app.getScreenshots());
                a.setIcon(app.getIcon());
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean deleteApplications(int id) {
        return false;
    }
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
    public Application getApplicationToUpdate(String appname){
        for(Application a: database.applications)
        {
            if(a.getName().equals(appname)){
                return a;
            }
        }
        return null;
    }
    @Override
    public File downloadApplications(int id) {
        return null;
    }

    @Override
    public Application getApplicationInfoByName(String name) {
        for (Application app : database.applications){
            if (app.getName().equals(name)){
                return app;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Application> getApplicationsByCustomer(int id) {
        if(id != 0){
            return null;
        }else{
            return new ArrayList<Application>();
        }
    }
}
