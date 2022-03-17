package com.example.S3_GPS_Ivanti.business;

import com.example.S3_GPS_Ivanti.model.Application;
import com.example.S3_GPS_Ivanti.model.Response;
import com.example.S3_GPS_Ivanti.model.Review;
import com.example.S3_GPS_Ivanti.model.User;
import com.example.S3_GPS_Ivanti.repository.ResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService{

    private final ResponseRepository responseRepository;
    private final ApplicationService applicationService;


    @Override
    public ArrayList<Response> getResponse( int reviewID) {
        return responseRepository.getResponse(reviewID);
    }

    @Override
    public boolean createResponse( int reviewID, Response response, User user) {
        ArrayList<Application> applications = applicationService.getAllOfAUsersAppointments(user);

        for(Application a : applications) {
            for(Review r : a.getReviews()) {
                if(r.getId() == reviewID) {
                return responseRepository.createResponse(reviewID, response);
                }
            }
        }

        return false;
    }

    @Override
    public boolean updateResponse( Response response, User user) {
        ArrayList<Response> responses = getAllOfAUsersResponses(user);

        for(Response r: responses) {
            if( r.getId() == response.getId()) {
                return responseRepository.updateResponse(response);
            }
        }

        return false;
    }

    @Override
    public boolean deleteResponse( int responseID, User user) {

        ArrayList<Response> responses = getAllOfAUsersResponses(user);

        for(Response r: responses)
        {
            if( r.getId() == responseID)
            {
                return responseRepository.deleteResponse(responseID);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Response> getAllOfAUsersResponses(User user) {
        return responseRepository.getAllOfAUsersResponses(user);
    }
}
