package s3_gps_ivanti.model;

import lombok.*;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private String id;
    private String name;
    private String description;
    private int totalDownloads;
    private ArrayList<String> screenshots;
    private String icon;
    private Creator creator;
    private ArrayList<Review> reviews;

    public Application(UpdateApplicationDTO updateDTO) {
        this.id = updateDTO.getId();
        this.name = updateDTO.getName();
        this.description = updateDTO.getDescription();
        this.screenshots = updateDTO.getImages();
        this.icon = updateDTO.getIcon();
    }
}
