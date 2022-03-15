package com.example.Individual_Project.repository;

import com.example.Individual_Project.model.*;

import java.util.ArrayList;

public class DataBaseForNow {

    public ArrayList<User> users;
    public ArrayList<Review> reviews;
    public ArrayList<Application> applications;
    public ArrayList<Response> responses;

    public DataBaseForNow()
    {
        //Create users
        Creater user1 = new Creater("Lars1", "Lars1");
        Creater user2 = new Creater("Lars2", "Lars2");
        Customer user3 = new Customer("Lars3", "Lars3");

        //Create applications
        Application application1 = new Application(1, user1, null);
        Application application2 = new Application(2, user2, null);
        Application application3 = new Application(3, user2, null);

        //Create reviews
        Review review1 = new Review(1,null, user3);
        Review review2 = new Review(2,null, user3);


        //Adding the reviews to the applications
        ArrayList<Review> reviews1 = new ArrayList<Review>();
        reviews1.add(review1);
        ArrayList<Review> reviews2 = new ArrayList<Review>();
        reviews2.add(review2);

        application1.setReviews(reviews1);
        application2.setReviews(reviews2);

        //Giving applications to users
        ArrayList<Application> applications1 = new ArrayList<Application>();
        applications1.add(application1);
        user1.setMyApplications(applications1);

        ArrayList<Application> applications2 = new ArrayList<Application>();
        applications2.add(application2);
        applications2.add(application3);
        user2.setMyApplications(applications2);
    }
}
