package s3_gps_ivanti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import s3_gps_ivanti.repository.entity.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
    boolean existsByCustomerAndAndApplicationName(String customer, String application);
    Review findByCustomerAndAndApplicationName(String customer, String application);
    int countByApplicationName(String application);
}
