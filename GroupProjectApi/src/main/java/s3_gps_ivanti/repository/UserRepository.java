package s3_gps_ivanti.repository;

import s3_gps_ivanti.model.User;

public interface UserRepository {
    User getUserById(int id);
}
