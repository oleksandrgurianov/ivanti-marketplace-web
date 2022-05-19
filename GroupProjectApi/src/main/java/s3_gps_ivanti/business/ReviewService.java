package s3_gps_ivanti.business;

import s3_gps_ivanti.DTO.*;
import s3_gps_ivanti.model.Review;



import java.util.ArrayList;

public interface ReviewService {
    boolean createReview(CreateReviewRequestDTO review);

    boolean updateReview(UpdateReviewRequestDTO review);

    boolean deleteReview(int reviewID);
}
