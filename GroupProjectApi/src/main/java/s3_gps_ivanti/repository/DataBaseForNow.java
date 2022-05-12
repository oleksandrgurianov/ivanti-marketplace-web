package s3_gps_ivanti.repository;

import s3_gps_ivanti.model.*;

import java.util.ArrayList;
import java.util.List;

public class
DataBaseForNow {

    public ArrayList<User> users;
    public ArrayList<Review> reviews;
    public ArrayList<Application> applications;
    public ArrayList<Response> responses;
    public ArrayList<Creator> creators;

    public DataBaseForNow()
    {
        String Connector= "Connector for utilities";

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

        // add users to list
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        creators.add(user1);
        creators.add(user2);

        ArrayList<String> images = new ArrayList<>();
        images.add("https://drive.google.com/uc?export=view?&id=17_X2XpvUdGWe9DfK42MLL2sdrC1ZxOhF");
        images.add("https://drive.google.com/uc?export=view?&id=17_X2XpvUdGWe9DfK42MLL2sdrC1ZxOhF");

        // link for google drive images
        // https://drive.google.com/uc?export=view?&id=1ZODotP7B6XRPyTqxBc_pFO7vbE5iXWei/view?usp=sharing

        // list of screenshots
        ArrayList<String> screenshots = new ArrayList<>();
        String image1 = "https://drive.google.com/uc?export=view?&id=1rIr1Tcdjs2yRiUAhP0g81cQT7ILiaV-j";
        String image2 = "https://drive.google.com/uc?export=view?&id=14UK4dsvwMNOeRk5rQ6LtRGLnHPe72ToV";
        String image3 = "https://drive.google.com/uc?export=view?&id=1EzEOklCWRhiDu7cPSVv9qAqulTgHJbxz";
        screenshots.add(image1);
        screenshots.add(image2);
        screenshots.add(image3);


        String Description = "Description";

        //Create applications
        Application application1 = new Application(1, "Ivanti Asset Manager", "app to manage your Ivanti assets",  screenshots, "https://drive.google.com/uc?export=view?&id=1ZODotP7B6XRPyTqxBc_pFO7vbE5iXWei", user1, null, "", null);
        Application application2 = new Application(2, "Ivanti Service Manager Utility Connector", Connector,  screenshots, "https://drive.google.com/uc?export=view?&id=1Vlk31koCI9f99V9RkOjw0e37W5OnQ3GZ", user1, null, "", null);
        Application application3 = new Application(3, "Microsoft Office365 Connector", "Connect to Office365",  screenshots, "https://drive.google.com/uc?export=view?&id=1TpiX-cQCYKTl89Aepxo2KMuBVWRraS5f", user2, null, "", null);
        Application application4 = new Application(4, "Windows 10 Accelerator", Connector,  screenshots, "https://drive.google.com/uc?export=view?&id=1c3sJgzDf5DVWnF3EXd0YZdFxOjAg0R0L", user1, null, "", null);
        Application application5 = new Application(5, "RES.Workspace.Delete.Windows.Profile", Connector,  screenshots, "https://drive.google.com/uc?export=view?&id=18LlRkzXZthIqQlaxip-Xrb3qMo-HExMq", user1, null, "", null);
        Application application6 = new Application(6, "Windows 11 Accelerator", Connector,  screenshots, "https://drive.google.com/uc?export=view?&id=1c3sJgzDf5DVWnF3EXd0YZdFxOjAg0R0L", user2, null, "", null);
        Application application7 = new Application(7, "Microsoft Excel", "This is microsoft excel, you can do a lot of things here like make a nice spreadsheet to keep track of your finances or other things you like to keep track of. It is very interesting.", screenshots, "https://drive.google.com/uc?export=view?&id=1TpiX-cQCYKTl89Aepxo2KMuBVWRraS5f", user1, null, "", null);
        Application application8 = new Application(8, "Another Ad Blocker", Description, screenshots, "icon", user2, null, "", null);
        Application application9 = new Application(9, "Probably Ad Blocker", Description, screenshots, "icon", user2, null, "", null);
        Application application10 = new Application(10, "One More Ad Blocker", Description, screenshots, "icon", user2, null, "", null);

        DownloadsPerMonth download11 = new DownloadsPerMonth(1, 2022, "January", 100);
        DownloadsPerMonth download21 = new DownloadsPerMonth(2, 2022, "February", 300);
        DownloadsPerMonth download31 = new DownloadsPerMonth(3, 2022, "March", 520);
        DownloadsPerMonth download41 = new DownloadsPerMonth(4, 2022, "April", 400);
        DownloadsPerMonth download51 = new DownloadsPerMonth(5, 2022, "May", 100);

        Version version1 = new Version(1l,1.0,1320,"here",List.of(download11,download21,download31,download41,download51));
        Version version2 = new Version(2l,2.0,1320,"here",List.of(download11,download21,download31,download41,download51));
        Version version3 = new Version(3l,2.1,1320,"here",List.of(download11,download21,download31,download41,download51));
        Version version4 = new Version(4l,2.2,1320,"here",List.of(download11,download21,download31,download41,download51));
        application1.setVersions(List.of(version1,version2,version3,version4));

        // add applications to list
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


        ArrayList<DownloadsPerMonth> downloads1 = new ArrayList<>();
        downloads1.add(download11);
        downloads1.add(download21);
        downloads1.add(download31);
        downloads1.add(download41);
        downloads1.add(download51);
        application1.setDownloads(downloads1);

        ArrayList<DownloadsPerMonth> downloads2 = new ArrayList<>();
        DownloadsPerMonth download1 = new DownloadsPerMonth(1, 2022, "January", 200);
        DownloadsPerMonth download2 = new DownloadsPerMonth(2, 2022, "February", 225);
        DownloadsPerMonth download3 = new DownloadsPerMonth(3, 2022, "March", 220);
        DownloadsPerMonth download4 = new DownloadsPerMonth(4, 2022, "April", 230);
        DownloadsPerMonth download5 = new DownloadsPerMonth(5, 2022, "May", 200);
        downloads2.add(download1);
        downloads2.add(download2);
        downloads2.add(download3);
        downloads2.add(download4);
        downloads2.add(download5);
        application2.setDownloads(downloads2);

        ArrayList<DownloadsPerMonth> downloads3 = new ArrayList<>();
        DownloadsPerMonth download13 = new DownloadsPerMonth(1, 2022, "January", 50);
        DownloadsPerMonth download23 = new DownloadsPerMonth(2, 2022, "February", 500);
        DownloadsPerMonth download33 = new DownloadsPerMonth(3, 2022, "March", 120);
        DownloadsPerMonth download43 = new DownloadsPerMonth(4, 2022, "April", 370);
        DownloadsPerMonth download53 = new DownloadsPerMonth(5, 2022, "May", 800);
        downloads3.add(download13);
        downloads3.add(download23);
        downloads3.add(download33);
        downloads3.add(download43);
        downloads3.add(download53);
        application3.setDownloads(downloads3);

        //reviews
        Review review1 = new Review(1, user3, 1, "This app sucks", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going ....", null);
        Review review2 = new Review(1, user3, 2, "This content creator sucks", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going ....", null);
        Review review3 = new Review(1, user3, 1, "Ban this guy", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going ....", null);
        Review review4 = new Review(1, user4, 4, "Great app loved it", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going ....", null);
        Review review5 = new Review(1, user4, 5, "Top tier", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going ....", null);


        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);
        reviews.add(review3);
        reviews.add(review4);
        reviews.add(review5);

        application1.setReviews(reviews);
        application2.setReviews(reviews);
        application3.setReviews(reviews);
        application4.setReviews(reviews);
        application5.setReviews(reviews);
        application6.setReviews(reviews);
        application7.setReviews(reviews);
        application8.setReviews(reviews);
        application9.setReviews(reviews);
        application10.setReviews(reviews);


        //Giving applications to users
        ArrayList<Application> applications1 = new ArrayList<>();
        for (Application app : applications){
            if (app.getCreator().getId() == 1){
                applications1.add(app);
            }
        }
        user1.setMyApplications(applications1);

        ArrayList<Application> applications2 = new ArrayList<>();
        for (Application app : applications){
            if (app.getCreator().getId() == 2){
                applications2.add(app);
            }
        }
        user2.setMyApplications(applications2);
    }
}
