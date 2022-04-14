package s3_gps_ivanti.repository.impl;


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

    @Override
    public ArrayList<Application> getApplicationsSorted(boolean rating, boolean date) {
        return null;
    }

    @Override
    public ArrayList<Application> getApplicationsBySearch(String search) {
        return null;
    }

    @Override
    public Application getApplicationsByID(long ID) {
        for(Application p : database.applications) {
            if (p.getId() == ID) {
                return p;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Application> getApplications() {
        return database.applications;
    }

    @Override
    public ArrayList<Application> getApplicationsByCreator(int id) {
        ArrayList<Application> creatorApps = new ArrayList<>();

        for (Application app : database.applications){
            if (app.getCreator().getId() == id){
                creatorApps.add(app);
            }
        }

        return creatorApps;

//            for (User creator : database.users){
//                if (creator.getId() == id){
//                    if (creator instanceof Creator){
//                        return ((Creator)creator).getMyApplications();
//                    }
//                }
//            }
//
//            return null;

    }

    @Override
    public boolean createApplications(Application app) {
        return false;
    }

    @Override
    public boolean updateApplications(Application app) {
        return false;
    }

    @Override
    public boolean deleteApplications(int appID) {
        return false;
    }

    @Override
    public File downloadApplications(int appID) {
        return null;
    }

    public ArrayList<Application> getAllOfAUsersAppointments(User user) {return null;}
}
