package s3_gps_ivanti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import s3_gps_ivanti.repository.entity.Review;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {

    @Query("{applicationID:'?0'}")
    List<Review> findAllByApplicationID(String applicationID);
}
