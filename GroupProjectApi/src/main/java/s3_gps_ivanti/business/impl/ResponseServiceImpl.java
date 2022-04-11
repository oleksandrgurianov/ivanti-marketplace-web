
package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.business.ResponseService;
import s3_gps_ivanti.model.Response;
import s3_gps_ivanti.repository.ResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responseRepository;

    @Override
    public ArrayList<Response> getResponse(int reviewID){
        return responseRepository.getResponse(reviewID);
    }

    @Override
    public boolean createResponse(int reviewID, Response response){
        return responseRepository.createResponse(reviewID, response);
    }

    @Override
    public boolean updateResponse( Response response){
        return responseRepository.updateResponse(response);
    }

    @Override
    public boolean deleteResponse( int responseID){
        return responseRepository.deleteResponse(responseID);
    }
}
