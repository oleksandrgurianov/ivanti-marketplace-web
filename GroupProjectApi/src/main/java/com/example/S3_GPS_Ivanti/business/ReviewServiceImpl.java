package com.example.S3_GPS_Ivanti.business;

import com.example.S3_GPS_Ivanti.model.Review;
import com.example.S3_GPS_Ivanti.model.User;
import com.example.S3_GPS_Ivanti.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Override
    public ArrayList<Review> getReviewsSorted( boolean rating, boolean date) {
        return reviewRepository.getReviewsSorted(rating, date);
    }

    @Override
    public ArrayList<Review> getReviews( boolean rating, boolean date) {
        return reviewRepository.getReviews(rating, date);
    }

    @Override
    public boolean createReview(Review review) {
        return reviewRepository.createReview(review);
    }

    @Override
    public boolean updateReview( Review review, User user) {
        ArrayList<Review> reviews = getAllOfAUsersReviews(user);

        for(Review r: reviews)
        {
            if( r.getId() == review.getId())
            {
                return reviewRepository.updateReview(review);
            }
        }
        return false;
    }

    @Override
    public boolean deleteReview( int reviewID, User user) {
        ArrayList<Review> reviews = getAllOfAUsersReviews(user);

        for(Review r: reviews)
        {
            if( r.getId() == reviewID)
            {
                return reviewRepository.deleteReview(reviewID);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Review> getAllOfAUsersReviews(User user) {
        return reviewRepository.getAllOfAUsersReviews(user);
    }
}
