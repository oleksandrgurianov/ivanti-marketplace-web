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

    public Customer(int id, String username, String password, ArrayList<Review> myReviews, ArrayList<Application> downloadedApplications)
    {
        super(id, username, password);
        this.myReviews = myReviews;
        this.downloadedApplications = downloadedApplications;
    }

    public Customer(int id, String username, String password){
        super(id, username, password);
        this.myReviews = new ArrayList<>();
        this.downloadedApplications = new ArrayList<>();
    }
}
