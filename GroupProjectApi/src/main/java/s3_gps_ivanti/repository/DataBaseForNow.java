package s3_gps_ivanti.repository;

import s3_gps_ivanti.model.*;

import java.util.ArrayList;

public class
DataBaseForNow {

    public ArrayList<User> users;
    public ArrayList<Review> reviews;
    public ArrayList<Application> applications;
    public ArrayList<Response> responses;
    public ArrayList<Creator> creators;

    public DataBaseForNow()
    {

        users = new ArrayList<>();
        reviews = new ArrayList<>();
        applications = new ArrayList<>();
        responses = new ArrayList<>();
        creators = new ArrayList<>();

     //Create users
        Creator user1 = new Creator(1, "Lars1", "Lars1",null,null);
        Creator user2 = new Creator(2, "Lars2", "Lars2",null,null);
        Customer user3 = new Customer(3, "Lars3", "Lars3", null, null);
        Customer user4 = new Customer (4, "Customer", "Customer");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        creators.add(user1);
        creators.add(user2);

        ArrayList<String> images = new ArrayList<>();
        images.add("https://drive.google.com/uc?export=view?&id=1tFkazCdwZids6CqOHPWMVxq-DQwZ2sJW/");
        images.add("https://drive.google.com/uc?export=view?&id=12lGO68ekH92R_uMS7NyZ1-ZAZ8jJA7fD/");

        //Create applications
        Application application1 = new Application();
        application1.setName("Ad Blocker");
        application1.setId(1);
        application1.setIcon("Icon here");
        application1.setDescription("description here");
        application1.setScreenshots(images);

        Application application2 = new Application();
        application2.setName("Another Ad Blocker");
        application2.setId(2);
        application1.setIcon("Icon here");
        application1.setDescription("description here");
        application2.setScreenshots(images);


        Application application3 = new Application();
        application3.setName("Probably Ad Blocker");
        application3.setId(3);
        application1.setIcon("Icon here");
        application1.setDescription("description here");
        application3.setScreenshots(images);

        Application application4 = new Application();
        application3.setName("Probably Ad Blocker");
        application3.setId(3);
        application1.setIcon("Icon here");
        application1.setDescription("description here");
        application3.setScreenshots(images);

        ArrayList<DownloadsPerMonth> downloads = new ArrayList<>();
        DownloadsPerMonth download1 = new DownloadsPerMonth(1, 2022, "January", 200);
        DownloadsPerMonth download2 = new DownloadsPerMonth(2, 2022, "February", 225);
        DownloadsPerMonth download3 = new DownloadsPerMonth(3, 2022, "March", 220);
        DownloadsPerMonth download4 = new DownloadsPerMonth(4, 2022, "April", 230);
        DownloadsPerMonth download5 = new DownloadsPerMonth(5, 2022, "May", 200);
        downloads.add(download1);
        downloads.add(download2);
        downloads.add(download3);
        downloads.add(download4);
        downloads.add(download5);
        application1.setDownloads(downloads);
        application2.setDownloads(downloads);
        application3.setDownloads(downloads);


        //Giving applications to users
        ArrayList<Application> applications1 = new ArrayList<>();
        applications1.add(application1);
        applications1.add(application2);
        applications1.add(application3);
        user1.setMyApplications(applications1);

        ArrayList<Application> applications2 = new ArrayList<>();
        applications2.add(application2);
        applications2.add(application3);
        applications2.add(application4);
        user2.setMyApplications(applications2);

        applications.add(application1);
        applications.add(application2);
        applications.add(application3);
    }
}
