package s3_gps_ivanti.model;

import lombok.*;
import s3_gps_ivanti.DTO.CreateReviewRequestDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private long id;
    private Customer customer;
    private long rating;
    private String title;
    private String description;
    private Response response;
}
