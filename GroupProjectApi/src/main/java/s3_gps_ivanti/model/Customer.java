package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    private ArrayList<Review> myReviews;
    private ArrayList<Application> downloadedApplications;

    public Customer(String username, String password, ArrayList<Review> myReviews, ArrayList<Application> downloadedApplications)
    {
        super(username, password);
        this.myReviews = myReviews;
        this.downloadedApplications = downloadedApplications;
    }

    public Customer(String username, String password){
        super(username, password);
        this.username= username;
        this.password = password;
    }
}
