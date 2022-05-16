package s3_gps_ivanti.repository.impl;

import s3_gps_ivanti.model.Review;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.ReviewRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Primary
@Service
public class ReviewRepositoryImpl implements ReviewRepository {

    @Override
    public ArrayList<Review> getReviews(String appName) {
        return new ArrayList<Review>();
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
        if(user != null) {
            return null;
        } else{
            return new ArrayList<Review>();
        }
    };
}
