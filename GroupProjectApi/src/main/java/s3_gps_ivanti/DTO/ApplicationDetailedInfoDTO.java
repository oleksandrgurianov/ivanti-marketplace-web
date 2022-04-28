package s3_gps_ivanti.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.WithBy;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.model.Review;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApplicationDetailedInfoDTO {

    private String name;
    private String icon;
    private String description;
    private List<String> images;
    private int totalDownloads;
    private int avgRating;
    private List<VersionDownloadDTO> versions;
    //private Creator creator;

    public ApplicationDetailedInfoDTO(Application app)
    {
        this.name = app.getName();
        this.icon = app.getIcon();
        this.description = app.getDescription();
        this.images = app.getScreenshots();
        this.totalDownloads = app.getTotalDownloads();
        this.avgRating = 0;
//        this.reviews = reviews;
        this.versions = null;
       //this.creator = app.getCreator();
    }
}
