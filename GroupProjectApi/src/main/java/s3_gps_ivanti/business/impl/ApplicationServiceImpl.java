package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.DTO.ApplicationDetailedInfoDTO;
import s3_gps_ivanti.DTO.ApplicationStatisticsDTO;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;
import s3_gps_ivanti.business.ApplicationService;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;
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
    public ApplicationDetailedInfoDTO getApplicationInfoByID(int id)
    {
        Application app = applicationRepository.getApplicationsByID(id);

        if (app != null){
            return new ApplicationDetailedInfoDTO(app);
        }
        return null;
    }
    @Override
    public ArrayList<Application> getApplicationDetails(String appName){
        return applicationRepository.getApplicationDetails(appName);
    }


    @Override
    public ArrayList<Application> getApplications() {
        return applicationRepository.getApplications();
    }

    //Creator
    @Override
    public  ArrayList<Application> getApplicationsByCreator(int id){
        return applicationRepository.getApplicationsByCreator(id);
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
        else if(app.getAppLocation() == null) {
            return false;
        }

        Creator creator =  new Creator();
        creator.setId(app.getCreatorId());

        Application model = new Application(app, creator);
        return applicationRepository.createApplications(model);
    }

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
        if(app.getId() == 0 ||
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
    public boolean deleteApplications(String name){
        boolean result = false;
        if(getApplicationInfoByName(name)!=null){
            applicationRepository.deleteApplications(name);

        }
        return result;
    }

    //Customers
    @Override
    public  ArrayList<Application> getApplicationsByCustomer(int id){
        return applicationRepository.getApplicationsByCustomer(id);
    }
    @Override
    public File downloadApplications(int id) {
        return applicationRepository.downloadApplications(id);
    }

    @Override
    public ApplicationDetailedInfoDTO getApplicationInfoByName(String name)
    {
        Application app = applicationRepository.getApplicationInfoByName(name);

        if (app != null){
            return new ApplicationDetailedInfoDTO(app);
        }
        return null;
    }

    public ArrayList<ApplicationStatisticsDTO> getApplicationStatisticsDTO(ArrayList<Application> applications){
        ArrayList<ApplicationStatisticsDTO> applicationStatisticsDTOList = new ArrayList<>();

        for (Application app: applications){
            ApplicationStatisticsDTO dto = new ApplicationStatisticsDTO(app);
            applicationStatisticsDTOList.add(dto);
        }
        return applicationStatisticsDTOList;
    }
}
