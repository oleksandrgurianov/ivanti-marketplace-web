package s3_gps_ivanti.business.validitycheck;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.exception.InvalidReviewException;
import s3_gps_ivanti.repository.ReviewRepository;

@Service
@AllArgsConstructor
public class ReviewIDValidCheck {
    private ReviewRepository reviewRepository;

    public void reviewInvalid(String id){
        if(!reviewRepository.existsById(id)){
            throw new InvalidReviewException();
        }
    }
}
