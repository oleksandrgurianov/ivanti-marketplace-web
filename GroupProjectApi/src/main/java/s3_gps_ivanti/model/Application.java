package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private int id;
    private String name;
    private String description;
    private int totalDownloads;
    private ArrayList<String> screenshots;
    private String icon;
    private Creator creator;
    private ArrayList<Review> reviews;

    public Application(String name, String description, ArrayList<String> screenshots, String icon){
        this.name = name;
        this.description = description;
        this.screenshots = screenshots;
        this.icon = icon;
    }
}
