package S3_GPS_Ivanti.business;

import S3_GPS_Ivanti.model.Review;
import S3_GPS_Ivanti.model.User;

import java.util.ArrayList;

public interface ReviewService {

    ArrayList<Review> getReviews(String appName);

    boolean createReview(Review review);

    boolean updateReview(Review review);

    boolean deleteReview(int reviewID);
}
