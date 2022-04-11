package s3_gps_ivanti.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DownloadsPerMonth {
    private int id;
    private int year;
    private String month;
    private int amount;
}
