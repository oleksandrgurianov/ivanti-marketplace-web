package s3_gps_ivanti.repository.impl;

import s3_gps_ivanti.model.Response;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.ResponseRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Primary
@Service
public class ResponseRepositoryImpl implements ResponseRepository {

    @Override
    public ArrayList<Response> getResponse(int reviewID) {
        return new ArrayList<Response>();
    }

    @Override
    public boolean createResponse(int reviewID, Response response) {
        return false;
    }

    @Override
    public boolean updateResponse(Response response) {
        return false;
    }

    @Override
    public boolean deleteResponse(int responseID) {
        return false;
    }

    public ArrayList<Response> getAllOfAUsersResponses(User user)  {
        if(user != null){
            return null;
        }else{
            return new ArrayList<Response>();
        }
    }
}
