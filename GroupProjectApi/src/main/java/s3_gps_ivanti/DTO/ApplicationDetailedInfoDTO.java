package s3_gps_ivanti.DTO;

import lombok.Data;
import s3_gps_ivanti.model.Application;
//import s3_gps_ivanti.model.Review;

import java.util.ArrayList;

@Data
public class ApplicationDetailedInfoDTO {

    private String name;
    private String description;
    private ArrayList<String> images;
    private int totalDownloads;
    private int avgRating;
//    private ArrayList<Review> reviews;
    private ArrayList<VersionDownloadDTO> versions;

    public ApplicationDetailedInfoDTO(Application app)
    {
        this.name = app.getName();
        this.description = app.getDescription();
        this.images = null;
        this.totalDownloads = app.getTotalDownloads();
        this.avgRating = 0;
//        this.reviews = reviews;
        this.versions = null;
    }
}
