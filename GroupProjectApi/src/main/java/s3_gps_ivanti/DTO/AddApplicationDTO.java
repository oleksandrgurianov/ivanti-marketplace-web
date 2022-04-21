package s3_gps_ivanti.DTO;

import lombok.Data;
import lombok.NonNull;
import s3_gps_ivanti.model.Application;

import java.util.ArrayList;

@Data
public class AddApplicationDTO {

    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private ArrayList<String> images;
    @NonNull
    private String icon;
    @NonNull
    private String appLocation;

    public AddApplicationDTO(String title, String description, ArrayList<String> images, String icon, String appLocation)
    {
        this.title = title;
        this.description = description;
        this.images = images;
        this.icon = icon;
        this.appLocation = appLocation;
    }
    public AddApplicationDTO(Application app)
    {
        this.title = app.getName();
        this.description = app.getDescription();
        this.images = app.getScreenshots();
        this.icon = app.getIcon();
        this.appLocation = app.getAppLocation();
    }
}
