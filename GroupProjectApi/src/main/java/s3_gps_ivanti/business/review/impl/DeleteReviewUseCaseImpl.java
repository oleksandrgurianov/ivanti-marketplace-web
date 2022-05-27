package s3_gps_ivanti.business.review.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.review.DeleteReviewUseCase;
import s3_gps_ivanti.business.validitycheck.ReviewIDValidCheck;
import s3_gps_ivanti.repository.ReviewRepository;

@Service
@Primary
@RequiredArgsConstructor
public class DeleteReviewUseCaseImpl implements DeleteReviewUseCase {

    private final ReviewRepository reviewRepository;
    private final ReviewIDValidCheck idValidCheck;


    @Override
    public void deleteReview(String id) {
        idValidCheck.reviewInvalid(id);

        reviewRepository.deleteById(id);
    }


}
