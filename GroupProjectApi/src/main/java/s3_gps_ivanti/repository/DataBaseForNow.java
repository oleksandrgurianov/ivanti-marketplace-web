package s3_gps_ivanti.repository;

import s3_gps_ivanti.model.*;

import java.util.ArrayList;

public class
DataBaseForNow {

    public ArrayList<User> users;
    public ArrayList<Review> reviews;
    public ArrayList<Application> applications;
    public ArrayList<Response> responses;

    public DataBaseForNow()
    {

        users = new ArrayList<>();
        reviews = new ArrayList<>();
        applications = new ArrayList<>();
        responses = new ArrayList<>();

       //Create users
        Creator user1 = new Creator(1,"Lars1", "Lars1",null,null);
        Creator user2 = new Creator(2, "Lars2", "Lars2",null,null);
        Customer user3 = new Customer(3, "Lars3", "Lars3", null, null);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        //Create applications
        Application application1 = new Application(1, "App 1", "amazing app",  null, "icon", user1);
        Application application2 = new Application(2, "App 2", "better app",  null, "icon", user1);
        Application application3 = new Application(3, "App 3", "this app sucks",  null, "icon", user2);

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

        applications.add(application1);
        applications.add(application2);
        applications.add(application3);
    }
}
