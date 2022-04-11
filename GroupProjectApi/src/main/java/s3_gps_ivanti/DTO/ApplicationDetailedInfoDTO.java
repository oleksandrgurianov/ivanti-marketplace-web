package s3_gps_ivanti.DTO;

import lombok.Data;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Review;

import java.util.ArrayList;

@Data
public class ApplicationDetailedInfoDTO {
    private String name;
    private String description;
    private ArrayList<String> screenshots;
    private int totalDownloads;
    private int avgRating;
    private ArrayList<Review> reviews;
    private ArrayList<VersionDownloadDTO> versions;

    public ApplicationDetailedInfoDTO(Application application){
     this.name = application.getName();
     this.description = application.getDescription();
     this.totalDownloads = application.getTotalDownloads();
     this.avgRating = 0;
     this.screenshots = application.getScreenshots();
     this.reviews = application.getReviews();
     this.versions = new ArrayList<>();
    }
}
