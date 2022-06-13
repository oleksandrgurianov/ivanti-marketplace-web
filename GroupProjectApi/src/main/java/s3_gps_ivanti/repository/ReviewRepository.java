package s3_gps_ivanti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import s3_gps_ivanti.repository.entity.Review;
import s3_gps_ivanti.repository.entity.User;

public interface ReviewRepository extends MongoRepository<Review, String> {
    boolean existsByCustomerAndAndApplicationName(User customer, String application);
    Review findByCustomerAndAndApplicationName(User customer, String application);
}
