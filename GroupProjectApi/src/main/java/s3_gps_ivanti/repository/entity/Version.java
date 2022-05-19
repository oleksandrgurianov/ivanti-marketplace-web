package s3_gps_ivanti.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Version {
    private double number;
    private int totalDownloads;
    private String appLocation;
    private List<DownloadsPerMonth> downloads;
}
