package s3_gps_ivanti.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s3_gps_ivanti.model.Version;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVersionDTO {

    private double number;
    private int totalDownloads;

    public GetVersionDTO(Version version){
        this.number = version.getNumber();
        this.totalDownloads = version.getTotalDownloads();
    }
}
