package S3_GPS_Ivanti.business;

import S3_GPS_Ivanti.model.User;

public interface UserService {

    User getUser(String username, String password);
}
