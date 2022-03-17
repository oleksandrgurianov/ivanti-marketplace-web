package com.example.S3_GPS_Ivanti.repository;

import com.example.S3_GPS_Ivanti.model.Review;
import com.example.S3_GPS_Ivanti.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Primary
@Service
public class ReviewRepositoryImpl implements ReviewRepository{
    private DataBaseForNow database;
    @Override
    public ArrayList<Review> getReviewsSorted(boolean rating, boolean date) {
        return null;
    }

    @Override
    public ArrayList<Review> getReviews(boolean rating, boolean date) {
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
