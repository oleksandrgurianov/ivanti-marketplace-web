package s3_gps_ivanti.repository;

import s3_gps_ivanti.model.Response;

import java.util.ArrayList;

public interface ResponseRepository {

    ArrayList<Response> getResponse(int reviewID);

    boolean createResponse(int reviewID, Response response);

    boolean updateResponse(Response response);

    boolean deleteResponse(int responseID);

}
