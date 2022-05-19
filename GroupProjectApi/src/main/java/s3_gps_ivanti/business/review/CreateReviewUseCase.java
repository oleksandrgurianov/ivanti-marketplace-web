package s3_gps_ivanti.business.review;

import s3_gps_ivanti.dto.review.CreateReviewRequestDTO;

public interface CreateReviewUseCase {
    void createReview(CreateReviewRequestDTO review);

}
