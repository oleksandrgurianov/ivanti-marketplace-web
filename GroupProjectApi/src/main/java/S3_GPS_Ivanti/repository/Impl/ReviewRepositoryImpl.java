package S3_GPS_Ivanti.repository.Impl;

import S3_GPS_Ivanti.model.Review;
import S3_GPS_Ivanti.model.User;
import S3_GPS_Ivanti.repository.DataBaseForNow;
import S3_GPS_Ivanti.repository.ReviewRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Primary
@Service
public class ReviewRepositoryImpl implements ReviewRepository {
    private DataBaseForNow database;

    @Override
    public ArrayList<Review> getReviews(String appName) {
        return null;
    }
    @Override
    public boolean createReview(Review review) {
        return false;
    }

    @Override
    public boolean updateReview(Review review) {
        return false;
    }

    @Override
    public boolean deleteReview(int reviewID) {
        return false;
    }

    public ArrayList<Review> getAllOfAUsersReviews(User user) {
        return null;
    };
}
