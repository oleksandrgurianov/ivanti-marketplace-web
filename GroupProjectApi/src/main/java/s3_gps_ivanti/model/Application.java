package s3_gps_ivanti.model;

import lombok.*;
import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;

import java.util.ArrayList;
import java.util.List;

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
    private String appLocation;
    private Rating rating;
    private List<DownloadsPerMonth> downloads;


    public Application(String name, String description, ArrayList<String> screenshots, String icon, String appLocation) {
        this.name = name;
        this.description = description;
        this.screenshots = screenshots;
        this.icon = icon;
        this.appLocation = appLocation;
        screenshots = new ArrayList<String>();
        downloads = new ArrayList<>();
    }

    public int totalDownloads(){
        int total=0;
        for(DownloadsPerMonth download : downloads){
            total+=download.getAmount();
        }
        return total;
    }
    public double totalDownloadsForYear(int year){
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

    public Application(AddApplicationDTO addDTO) {
        this.name = addDTO.getTitle();
        this.description = addDTO.getDescription();
        this.screenshots = addDTO.getImages();
        this.icon = addDTO.getIcon();
        this.appLocation = addDTO.getAppLocation();
    }
}
