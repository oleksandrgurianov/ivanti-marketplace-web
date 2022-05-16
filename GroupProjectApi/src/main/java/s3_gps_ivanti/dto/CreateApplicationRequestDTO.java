package s3_gps_ivanti.dto;

import lombok.Builder;
import lombok.Data;
import s3_gps_ivanti.model.Application;

import java.util.List;

@Builder
@Data
public class CreateApplicationRequestDTO {


    private String name;

    private String description;

    private List<String> screenshots;

    private String icon;

    private String appLocation;

    private int creatorId;


    public CreateApplicationRequestDTO(String name, String description, List<String> screenshots, String icon, String appLocation, int creatorId)
    {
        this.name = name;
        this.description = description;
        this.screenshots = screenshots;
        this.icon = icon;
        this.appLocation = appLocation;
        this.creatorId = creatorId;
    }
    public CreateApplicationRequestDTO(Application app)
    {
        this.name = app.getName();
        this.description = app.getDescription();
        this.screenshots = app.getScreenshots();
        this.icon = app.getIcon();
        this.appLocation = app.getVersions().get(0).getAppLocation();
        this.creatorId = app.getCreator().getId();
    }
}
