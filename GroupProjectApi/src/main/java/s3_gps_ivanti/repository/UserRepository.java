package s3_gps_ivanti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import s3_gps_ivanti.repository.entity.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{username:'?0'}")
    User findUserByUsername(String username);

    @Query("{username:'?0', permission:'Customer'}")
    User findUserByUsernameAndPermission(String username);

    @Query("{_id:'?0', permission:'Customer'}")
    User findByIdAAndPermission(String id);

    @Query("{email:'?0'}")
    User findUserByEmail(String email);

    boolean existsByUsername(String name);
}



