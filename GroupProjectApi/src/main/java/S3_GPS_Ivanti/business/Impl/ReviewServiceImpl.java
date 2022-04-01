package S3_GPS_Ivanti.business.Impl;

import S3_GPS_Ivanti.business.ReviewService;
import S3_GPS_Ivanti.model.Review;
import S3_GPS_Ivanti.model.User;
import S3_GPS_Ivanti.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public ArrayList<Review> getReviews(String appName){
        return reviewRepository.getReviews(appName);
    }
    @Override
    public boolean createReview(Review review){
        return reviewRepository.createReview(review);
    }
    @Override
    public boolean updateReview(Review review){
        return reviewRepository.updateReview(review);
    }
    @Override
    public boolean deleteReview(int reviewID){
        return reviewRepository.deleteReview(reviewID);
    }
}
