package s3_gps_ivanti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import s3_gps_ivanti.repository.entity.Creator;
import s3_gps_ivanti.repository.entity.Customer;

public interface CreatorRepository  extends MongoRepository<Creator, String> {
    @Query("{email:'?0'}")
    Customer findByUser_Email(String email);
}
