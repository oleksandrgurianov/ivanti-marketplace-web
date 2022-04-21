package s3_gps_ivanti.business;

import s3_gps_ivanti.model.User;

public interface UserService {
    User getUserByID(int id);
}
