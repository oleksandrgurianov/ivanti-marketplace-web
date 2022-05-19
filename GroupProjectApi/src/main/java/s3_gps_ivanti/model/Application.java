package s3_gps_ivanti.model;

import lombok.*;
import s3_gps_ivanti.DTO.CreateApplicationRequestDTO;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private int id;
    private String name;
    private String description;
    private String icon;
    private Creator creator;
    private List<String> screenshots;
    private List<Version> versions;

    private int totalDownloads;
    private List<Review> reviews;
    private Rating rating;
    private List<DownloadsPerMonth> downloads;

    public Application(int id, String name, String description, List<String> screenshots, String icon, Creator creator, List<Review> reviews, String appLocation, Rating rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.totalDownloads = 0;
        this.screenshots = screenshots;
        this.icon = icon;
        this.creator = creator;
        this.reviews = reviews;
        this.versions = new ArrayList<>();

        versions.add(new Version(1.0,0,appLocation, Collections.emptyList()));

        this.rating = rating;
        this.downloads = new ArrayList<>();
    }

    public long totalDownloadsForYear(int year){
        int total=0;
        for(DownloadsPerMonth download : downloads){
            if(download.getYear()==year){
                total+=download.getAmount();
            }
        }
        return total;
    }

    public Application(UpdateApplicationDTO updateDTO) {
        this.id = updateDTO.getId();
        this.name = updateDTO.getName();
        this.description = updateDTO.getDescription();
        this.screenshots = updateDTO.getImages();
        this.icon = updateDTO.getIcon();
    }

    public Application(CreateApplicationRequestDTO addDTO, Creator creator) {
        this.name = addDTO.getName();
        this.description = addDTO.getDescription();
        this.screenshots = addDTO.getScreenshots();
        this.icon = addDTO.getIcon();
        versions = new ArrayList<>();
        versions.add(new Version(1.0,0,addDTO.getAppLocation(), Collections.emptyList()));
        this.creator = creator;
    }

}
