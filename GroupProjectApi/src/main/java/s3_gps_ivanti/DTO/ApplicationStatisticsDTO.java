package s3_gps_ivanti.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.DownloadsPerMonth;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationStatisticsDTO {
    private String name;
    private String icon;
    private List<DownloadsPerMonth> downloads;
    private long totalDownloads;

    public  ApplicationStatisticsDTO(Application app){
        this.name = app.getName();
        this.icon = app.getIcon();
        this.downloads = app.getDownloads();
        this.totalDownloads = app.totalDownloadsForYear(2022);
    }
}
