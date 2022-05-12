package s3_gps_ivanti.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewRequestDTO {
    private long id;
    private CustomerDTO customer;
    private long rating;
    private String title;
    private String description;
}
