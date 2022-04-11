package S3_GPS_Ivanti.repository;

import S3_GPS_Ivanti.model.User;

public interface UserRepository  {
    User getUser(String username, String password);
}
