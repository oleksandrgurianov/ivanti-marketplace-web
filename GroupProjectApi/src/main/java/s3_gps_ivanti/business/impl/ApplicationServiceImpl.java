package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.DTO.UpdateApplicationDTO;
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
    public Application getApplicationsByID(String id)
    {
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


    @Override
    public UpdateApplicationDTO getApplicationToUpdate(String appname){

        Application a = applicationRepository.getApplicationToUpdate(appname);

        if(a != null) {
            return new UpdateApplicationDTO(a);
        }
        else {
            return null;
        }
    }
    @Override
    public boolean updateApplications(UpdateApplicationDTO app ) {

        //Check input
        if(app.getId() == null || app.getId().equals("") ||
                app.getName() == null || app.getName().equals("") ||
                app.getDescription() == null || app.getDescription().equals("") ||
                app.getIcon() == null || app.getIcon().equals("") ||
                app.getImages().size() ==0 || app.getImages().size() > 10)
        {
            return  false;
        }

        Application model = new Application(app);

        return applicationRepository.updateApplications(model);
    }
    @Override
    public boolean deleteApplications(String appID ){
        return applicationRepository.deleteApplications(appID);
    }

    //Customers
    @Override
    public  ArrayList<Application> getApplicationsByCustomer(String ID){
        return applicationRepository.getApplicationsByCustomer(ID);
    }
    @Override
    public File downloadApplications(String appID) {
        return applicationRepository.downloadApplications(appID);
    }
}
