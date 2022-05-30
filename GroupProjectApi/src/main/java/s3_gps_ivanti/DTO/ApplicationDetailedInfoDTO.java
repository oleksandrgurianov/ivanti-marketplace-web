package s3_gps_ivanti.DTO;

import lombok.Data;
import s3_gps_ivanti.business.impl.dtoconverter.ReviewDTOConverter;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Version;

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
    private List<GetVersionDTO> versions;
    private List<VersionDownloadDTO> versionsDownloads;
    private List<ViewReviewDTO> reviews;

    public ApplicationDetailedInfoDTO(Application app)
    {
        this.name = app.getName();
        this.icon = app.getIcon();
        this.description = app.getDescription();
        this.images = app.getScreenshots();
        this.totalDownloads = app.getTotalDownloads();
        this.avgRating = 0;
        this.versionsDownloads = null;

        List<GetVersionDTO> versionsDTO = new ArrayList<>();

        for (Version v: app.getVersions()) {
            versionsDTO.add(new GetVersionDTO(v));
        }

        this.versions = versionsDTO;

        this.reviews = ReviewDTOConverter.convertToDTOList(app.getReviews());
    }
}
