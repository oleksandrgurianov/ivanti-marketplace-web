package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    private List<Review> myReviews;
    private List<Application> downloadedApplications;

    public Customer(int id, String username, String password, List<Review> myReviews, List<Application> downloadedApplications, String firstName, String lastName)
    {
        super(id, username, password, firstName, lastName);
        this.myReviews = myReviews;
        this.downloadedApplications = downloadedApplications;
    }

    public Customer(int id, String username, String password){
        super(id, username, password);
        this.myReviews = new ArrayList<>();
        this.downloadedApplications = new ArrayList<>();
    }
}
