package s3_gps_ivanti.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.DataBaseForNow;
import s3_gps_ivanti.repository.UserRepository;

@Primary
@Repository
public class UserRepositoryImpl implements UserRepository {

    private DataBaseForNow database = new DataBaseForNow();


    @Override
    public User getUserById(int id) {
        for (User user : database.users) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
