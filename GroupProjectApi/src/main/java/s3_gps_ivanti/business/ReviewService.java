package s3_gps_ivanti.business;

import s3_gps_ivanti.DTO.*;

public interface ReviewService {
    boolean createReview(CreateReviewRequestDTO review);

    boolean updateReview(UpdateReviewRequestDTO review);

    boolean deleteReview(int reviewID);
}
