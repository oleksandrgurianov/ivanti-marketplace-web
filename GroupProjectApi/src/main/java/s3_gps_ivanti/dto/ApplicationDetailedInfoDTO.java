package s3_gps_ivanti.dto;

import lombok.Data;
import s3_gps_ivanti.model.Application;

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

    public ApplicationDetailedInfoDTO(Application app)
    {
        this.name = app.getName();
        this.icon = app.getIcon();
        this.description = app.getDescription();
        this.images = app.getScreenshots();
        this.totalDownloads = app.getTotalDownloads();
        this.avgRating = 0;
        this.versions = null;
    }
}
