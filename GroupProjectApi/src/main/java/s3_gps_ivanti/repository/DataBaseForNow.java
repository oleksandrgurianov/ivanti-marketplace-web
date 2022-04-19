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
        Creator user1 = new Creator(1,"Lars123", "Lars1",null,null, "Lars", "Kluijtmans");
        Creator user2 = new Creator(2, "Esther66", "Password",null,null, "Esther", "Wolfs");
        Customer user3 = new Customer(3, "Mohammad7", "Khan123", null, null, "Mohammad", "Khan" );
        Customer user4 = new Customer(4, "Noelia", "Password", null, null, "Noelia", "Rodriguez Morales" );
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        //Create applications
        Application application1 = new Application(1, "Ivanti Asset Manager", "app to manage your Ivanti assets",  null, "https://drive.google.com/uc?export=view?&id=1ZODotP7B6XRPyTqxBc_pFO7vbE5iXWei", user1);
        Application application2 = new Application(2, "Ivanti Service Manager Utility Connector", "Connector for utilities",  null, "https://drive.google.com/uc?export=view?&id=1Vlk31koCI9f99V9RkOjw0e37W5OnQ3GZ", user1);
        Application application3 = new Application(3, "Microsoft Office365 Connector", "Connect to Office365",  null, "https://drive.google.com/uc?export=view?&id=1TpiX-cQCYKTl89Aepxo2KMuBVWRraS5f", user2);
        Application application4 = new Application(2, "Windows 10 Accelerator", "Connector for utilities",  null, "https://drive.google.com/uc?export=view?&id=1c3sJgzDf5DVWnF3EXd0YZdFxOjAg0R0L", user1);
        Application application5 = new Application(2, "RES.Workspace.Delete.Windows.Profile", "Connector for utilities",  null, "https://drive.google.com/uc?export=view?&id=18LlRkzXZthIqQlaxip-Xrb3qMo-HExMq", user1);
        Application application6 = new Application(2, "Windows 11 Accelerator", "Connector for utilities",  null, "https://drive.google.com/uc?export=view?&id=1c3sJgzDf5DVWnF3EXd0YZdFxOjAg0R0L", user1);

//        https://drive.google.com/uc?export=view?&id=1ZODotP7B6XRPyTqxBc_pFO7vbE5iXWei/view?usp=sharing

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
        applications.add(application3);
        applications.add(application3);
        applications.add(application4);
        applications.add(application5);
        applications.add(application6);

    }
}
