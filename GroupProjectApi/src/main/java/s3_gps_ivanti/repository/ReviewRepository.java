package s3_gps_ivanti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import s3_gps_ivanti.repository.entity.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
