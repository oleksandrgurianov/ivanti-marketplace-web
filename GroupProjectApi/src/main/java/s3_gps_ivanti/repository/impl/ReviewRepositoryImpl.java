package s3_gps_ivanti.repository.impl;

import s3_gps_ivanti.model.Review;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.DataBaseForNow;
import s3_gps_ivanti.repository.ReviewRepository;
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
