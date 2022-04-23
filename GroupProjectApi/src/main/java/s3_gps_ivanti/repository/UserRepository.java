package s3_gps_ivanti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import s3_gps_ivanti.model.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{username:'?0'}")
    User findUserByUsername(String username);

    @Query(value="{permission:'?0'}", fields="{'username' : 1, 'code' : 1}")
    List<User> findAll(String permission);

    public long count();

}
