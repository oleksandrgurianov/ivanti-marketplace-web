package com.example.S3_GPS_Ivanti.business;


import com.example.S3_GPS_Ivanti.model.*;

import java.util.ArrayList;

public interface ReviewService {

    ArrayList<Review> getReviews(String appName);

    boolean createReview(Review review);

    boolean updateReview(Review review);

    boolean deleteReview(int reviewID);
}
