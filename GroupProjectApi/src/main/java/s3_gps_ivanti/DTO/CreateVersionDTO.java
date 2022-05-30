package s3_gps_ivanti.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateVersionDTO {
    private String appName;
    private double number;
    private String appLocation;
}
