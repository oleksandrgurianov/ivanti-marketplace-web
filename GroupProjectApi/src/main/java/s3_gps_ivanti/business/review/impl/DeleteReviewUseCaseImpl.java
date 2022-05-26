package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.application.DeleteApplicationUseCase;
import s3_gps_ivanti.business.review.DeleteReviewUseCase;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.ReviewRepository;

@Service
@Primary
@RequiredArgsConstructor
public class DeleteReviewUseCaseImpl implements DeleteReviewUseCase {

    private final ReviewRepository reviewRepository;


    @Override
    public void deleteReview(ObjectId id) {
        reviewRepository.deleteById(id.toString());
    }
}
