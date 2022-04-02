package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.business.ReviewService;
import s3_gps_ivanti.model.Review;
import s3_gps_ivanti.repository.ReviewRepository;
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
