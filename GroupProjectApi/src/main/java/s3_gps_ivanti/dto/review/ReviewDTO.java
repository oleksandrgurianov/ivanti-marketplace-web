package s3_gps_ivanti.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s3_gps_ivanti.dto.user.CustomerSmallDetailDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private CustomerSmallDetailDTO customer;
    private int rating;
    private String title;
    private String description;
    private String response;
}
