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
        Creator user1 = new Creator(1,"Lars123", "Lars1",null,null, "Lars", "Kluijtmans");
        Creator user2 = new Creator(2, "Esther66", "Password",null,null, "Esther", "Wolfs");
        Customer user3 = new Customer(3, "Mohammad7", "Khan123", null, null, "Mohammad", "Khan" );
        Customer user4 = new Customer(4, "Noelia", "Password", null, null, "Noelia", "Rodriguez Morales" );
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        creators.add(user1);
        creators.add(user2);

        ArrayList<String> images = new ArrayList<>();
        images.add("https://drive.google.com/uc?export=view?&id=1tFkazCdwZids6CqOHPWMVxq-DQwZ2sJW/");
        images.add("https://drive.google.com/uc?export=view?&id=12lGO68ekH92R_uMS7NyZ1-ZAZ8jJA7fD/");

        //int id, String name, String description, ArrayList<String> screenshots, String icon, Creator creator, ArrayList<Review> reviews, String appLocation, Rating rating) {

        //Create applications
        Application application1 = new Application(1, "Ivanti Asset Manager", "app to manage your Ivanti assets",  null, "https://drive.google.com/uc?export=view?&id=1ZODotP7B6XRPyTqxBc_pFO7vbE5iXWei", user1, null, "", null);
        Application application2 = new Application(2, "Ivanti Service Manager Utility Connector", "Connector for utilities",  null, "https://drive.google.com/uc?export=view?&id=1Vlk31koCI9f99V9RkOjw0e37W5OnQ3GZ", user1, null, "", null);
        Application application3 = new Application(3, "Microsoft Office365 Connector", "Connect to Office365",  null, "https://drive.google.com/uc?export=view?&id=1TpiX-cQCYKTl89Aepxo2KMuBVWRraS5f", user2, null, "", null);
        Application application4 = new Application(2, "Windows 10 Accelerator", "Connector for utilities",  null, "https://drive.google.com/uc?export=view?&id=1c3sJgzDf5DVWnF3EXd0YZdFxOjAg0R0L", user1, null, "", null);
        Application application5 = new Application(2, "RES.Workspace.Delete.Windows.Profile", "Connector for utilities",  null, "https://drive.google.com/uc?export=view?&id=18LlRkzXZthIqQlaxip-Xrb3qMo-HExMq", user1, null, "", null);
        Application application6 = new Application(2, "Windows 11 Accelerator", "Connector for utilities",  null, "https://drive.google.com/uc?export=view?&id=1c3sJgzDf5DVWnF3EXd0YZdFxOjAg0R0L", user2, null, "", null);
        Application application7 = new Application(7, "Ad Blocker", "Description", null, "icon", user2, null, "", null);
        Application application8 = new Application(7, "Another Ad Blocked", "Description", null, "icon", user2, null, "", null);
        Application application9 = new Application(7, "Probably Ad Blocked", "Description", null, "icon", user2, null, "", null);
        Application application10 = new Application(7, "One More Ad Blocked", "Description", null, "icon", user2, null, "", null);

//        https://drive.google.com/uc?export=view?&id=1ZODotP7B6XRPyTqxBc_pFO7vbE5iXWei/view?usp=sharing

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
        applications.add(application4);
        applications.add(application5);
        applications.add(application6);
        applications.add(application7);
        applications.add(application8);
        applications.add(application9);
        applications.add(application10);
    }
}
