package S3_GPS_Ivanti.repository.Impl;

import S3_GPS_Ivanti.model.User;
import S3_GPS_Ivanti.repository.DataBaseForNow;
import S3_GPS_Ivanti.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserRepositoryImpl implements UserRepository {

    private DataBaseForNow database;

    @Override
    public User getUser(String username, String password) {
        return null;
    }
}
