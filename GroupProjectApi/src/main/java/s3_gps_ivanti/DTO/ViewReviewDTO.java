package s3_gps_ivanti.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewReviewDTO {
    private long id;
    private String customer;
    private long rating;
    private String title;
    private String description;
}
