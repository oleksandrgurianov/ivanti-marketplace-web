package s3_gps_ivanti.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s3_gps_ivanti.dto.CreateVersionDTO;
import s3_gps_ivanti.dto.UpdateVersionDTO;

import java.util.Collections;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Version {

    private Long id;
    private double number;
    private int totalDownloads;
    private String appLocation;
    private List<DownloadsPerMonth> downloadsPerMonths;


    public Version(double number, int totalDownloads, String appLocation, List<DownloadsPerMonth> downloadsPerMonths){
        this.number = number;
        this.totalDownloads = totalDownloads;
        this.appLocation = appLocation;
        this.downloadsPerMonths = downloadsPerMonths;
    }

    public Version(UpdateVersionDTO updateVersionDTO, Version version){
        this.id = version.getId();
        this.totalDownloads = version.getTotalDownloads();
        this.downloadsPerMonths = version.getDownloadsPerMonths();
        this.number = version.getNumber();

        //Updated info
        this.appLocation = updateVersionDTO.getAppLocation();
    }

    public Version(CreateVersionDTO createVersionDTO){
        this.totalDownloads = 0;
        this.downloadsPerMonths = Collections.emptyList();
        this.number = createVersionDTO.getNumber();
        this.appLocation = createVersionDTO.getAppLocation();
    }
}
