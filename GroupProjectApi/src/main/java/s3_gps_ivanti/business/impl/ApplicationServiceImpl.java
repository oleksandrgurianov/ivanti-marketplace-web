package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.business.ApplicationService;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    //all
    @Override
    public  ArrayList<Application> getApplicationsSorted(boolean rating, boolean date){
        return applicationRepository.getApplicationsSorted(rating, date);
    }
    @Override
    public ArrayList<Application> getApplicationsBySearch(String search){
        return applicationRepository.getApplicationsBySearch(search);
    }
    @Override
    public  Application getApplicationsByID(long id){
        return applicationRepository.getApplicationsByID(id);
    }
    @Override
    public ArrayList<Application> getApplicationDetails(String appName){
        return applicationRepository.getApplicationDetails(appName);
    }

    //Creator
    @Override
    public  ArrayList<Application> getApplicationsByCreator(String ID){
        return applicationRepository.getApplicationsByCreator(ID);
    }
    @Override
    public boolean createApplications( AddApplicationDTO app){

        if(app.getTitle() == "" || app.getTitle() == null) {
            return false;
        }
        else if(app.getDescription() == "" || app.getDescription() == null) {
            return false;
        }
        else if(app.getIcon() == "" || app.getIcon() == null) {
            return false;
        }
        else if(app.getImages() == null ) {
            return false;
        }
        else if(app.getImages().size() == 0 || app.getImages().size() > 10) {
            return false;
        }
        else if(applicationRepository.FindAppWithSameName(app.getTitle())) {
            return false;
        }

        Application modle = new Application(app.getTitle(), app.getDescription(), app.getImages(), app.getIcon(), app.getAppLocation());
        return applicationRepository.createApplications(modle);
    }
    @Override
    public boolean updateApplications(Application app){
        return applicationRepository.updateApplications(app);
    }
    @Override
    public   boolean deleteApplications( int appID){
        return applicationRepository.deleteApplications(appID);
    }

    //Customers
    @Override
    public  ArrayList<Application> getApplicationsByCustomer(String ID){
        return applicationRepository.getApplicationsByCustomer(ID);
    }
    @Override
    public File downloadApplications(int appID){
        return applicationRepository.downloadApplications(appID);
    }
}
