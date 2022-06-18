package s3_gps_ivanti.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReviewDTO {
    @NotNull
    private String id;
    @NotNull
    private String applicationName;
    @NotNull
    private String customerName;
    @NotNull
    private int rating;
    @NotNull
    private String title;
    @NotNull
    private String description;
}
