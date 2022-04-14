package s3_gps_ivanti.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.DownloadsPerMonth;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ApplicationStatisticsDTO {
    private String name;
    private List<DownloadsPerMonth> downloads;

    public  ApplicationStatisticsDTO(Application app){
        this.name = app.getName();
        this.downloads = app.getDownloads();
    }
}
