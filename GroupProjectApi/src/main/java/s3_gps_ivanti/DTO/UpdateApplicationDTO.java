package s3_gps_ivanti.DTO;

import lombok.Builder;
import lombok.Data;
import s3_gps_ivanti.model.Application;

import java.util.List;

@Data
@Builder
public class UpdateApplicationDTO {

    private int id;
    private String name;
    private String description;
    private List<String> images;
    private String icon;

    public UpdateApplicationDTO(int id, String name, String description, List<String> images, String icon)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.icon = icon;
    }

    public UpdateApplicationDTO(Application application)
    {
        this.id = application.getId();
        this.name = application.getName();
        this.description = application.getDescription();
        this.images = application.getScreenshots();
        this.icon = application.getIcon();
    }
}
