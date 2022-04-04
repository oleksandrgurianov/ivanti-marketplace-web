package s3_gps_ivanti.DTO;

import lombok.Data;
import s3_gps_ivanti.model.Review;

import java.util.ArrayList;

@Data
public class ApplicationDetailedInfoDTO {

    private String name;
    private String description;
    private ArrayList<String> images;
    private int totalDownloads;
    private int avgRating;
    private ArrayList<Review> reviews;
    private ArrayList<VersionDownloadDTO> versions;

    public ApplicationDetailedInfoDTO(String name, String description, ArrayList<String> images, int totalDownloads, int avgRating, ArrayList<Review> reviews,ArrayList<VersionDownloadDTO> versions)
    {
        this.name = name;
        this.description = description;
        this.images = images;
        this.totalDownloads = totalDownloads;
        this.avgRating = avgRating;
        this.reviews = reviews;
        this.versions = versions;
    }
}
