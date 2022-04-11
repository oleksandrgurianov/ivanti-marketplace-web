package s3_gps_ivanti.repository;

import s3_gps_ivanti.model.Review;


import java.util.ArrayList;

public interface ReviewRepository {

    ArrayList<Review> getReviews(String appName);

    boolean createReview(Review review);

    boolean updateReview(Review review);

    boolean deleteReview(int reviewID);
}
