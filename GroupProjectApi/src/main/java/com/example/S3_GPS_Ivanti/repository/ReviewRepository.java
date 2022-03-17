package com.example.S3_GPS_Ivanti.repository;

import com.example.S3_GPS_Ivanti.model.Review;
import com.example.S3_GPS_Ivanti.model.User;

import java.util.ArrayList;

public interface ReviewRepository {

    ArrayList<Review> getReviewsSorted(boolean rating, boolean date);

    ArrayList<Review> getReviews(boolean rating, boolean date);

    boolean createReview(Review review);

    boolean updateReview(Review review);

    boolean deleteReview(int reviewID);

    ArrayList<Review> getAllOfAUsersReviews(User user);
}
