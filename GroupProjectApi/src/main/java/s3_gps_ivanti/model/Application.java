package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

}
