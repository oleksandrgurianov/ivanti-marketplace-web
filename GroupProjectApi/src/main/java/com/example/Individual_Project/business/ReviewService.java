package com.example.Individual_Project.business;

import com.example.Individual_Project.model.Review;
import com.example.Individual_Project.model.User;

import java.util.ArrayList;

public interface ReviewService {

    ArrayList<Review> getReviewsSorted(boolean rating, boolean date);

    ArrayList<Review> getReviews( boolean rating, boolean date);

    boolean createReview( Review review);

    boolean updateReview( Review review, User user);

    boolean deleteReview( int reviewID, User user);

    ArrayList<Review> getAllOfAUsersReviews(User user);
}
