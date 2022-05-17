package s3_gps_ivanti.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingAnalytics {
    private int one_Star;
    private int two_Star;
    private int three_Star;
    private int four_Star;
    private int five_Star;
}
