package s3_gps_ivanti.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewRequestDTO {
    private CustomerDTO customer;
    private long rating;
    private String title;
    private String description;
    private String response;
}
