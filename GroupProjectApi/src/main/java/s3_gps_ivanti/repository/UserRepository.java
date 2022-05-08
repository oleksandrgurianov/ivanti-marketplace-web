package s3_gps_ivanti.repository;

<<<<<<< HEAD
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import s3_gps_ivanti.model.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{username:'?0'}")
    User findUserByUsername(String username);

   @Query(value="{permission:'?0'}", fields="{'username' : 1}")
    List<User> findAll(String permission);

    public long count();
=======
import s3_gps_ivanti.model.User;

public interface UserRepository {
    User getUserById(int id);
>>>>>>> 7bc270fc16b87b024207014898503027e46b34d0
}
