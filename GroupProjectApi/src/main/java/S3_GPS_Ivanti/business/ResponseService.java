package S3_GPS_Ivanti.business;

<<<<<<< HEAD:GroupProjectApi/src/main/java/S3_GPS_Ivanti/business/ResponseService.java
import S3_GPS_Ivanti.model.Response;
import S3_GPS_Ivanti.model.User;
=======
import com.example.S3_GPS_Ivanti.model.*;
>>>>>>> 75208ff8c276fbe9838fb7b8e36d120aec7926ff:GroupProjectApi/src/main/java/com/example/S3_GPS_Ivanti/business/ResponseService.java

import java.util.ArrayList;

public interface ResponseService {

    ArrayList<Response> getResponse(int reviewID);

    boolean createResponse( int reviewID, Response response, User user);

    boolean updateResponse( Response response, User user);

    boolean deleteResponse( int responseID, User user);

    public ArrayList<Response> getAllOfAUsersResponses(User user);
}
