package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.DTO.ApplicationDetailedInfoDTO;
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

    @Override
    public ArrayList<Application> getApplicationsSorted(boolean rating, boolean date) {
        return applicationRepository.getApplicationsSorted(rating, date);
    }

    @Override
    public ArrayList<Application> getApplicationsBySearch(String search) {
        return applicationRepository.getApplicationsBySearch(search);
    }

    @Override
    public Application getApplicationsByID(long id)
    {
       return applicationRepository.getApplicationsByID(id);
    }


    @Override
    public ArrayList<Application> getApplications() {
        return applicationRepository.getApplications();
    }

    @Override
    public boolean createApplications( Application app) {
        return applicationRepository.createApplications(app);
    }

    @Override
    public boolean updateApplications(Application app ) {
        return applicationRepository.updateApplications(app);
    }

    @Override
    public boolean deleteApplications(int appID ){
        return applicationRepository.deleteApplications(appID);
    }

    @Override
    public File downloadApplications(int appID) {
        return applicationRepository.downloadApplications(appID);
    }

    @Override
    public ArrayList<Application> getApplicationsByCreator(int id) {
        return applicationRepository.getApplicationsByCreator(id);
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
}
