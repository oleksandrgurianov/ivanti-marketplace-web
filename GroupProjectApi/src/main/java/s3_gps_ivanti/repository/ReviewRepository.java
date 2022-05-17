package s3_gps_ivanti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import s3_gps_ivanti.repository.entity.Review;
import s3_gps_ivanti.repository.entity.User;

public interface ReviewRepository extends MongoRepository<Review, String> {
    @Query("{username:'?0'}")
    User findUserByUsername(String username);

}
