package s3_gps_ivanti.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private Long id;
    private Long application_id;
    private Long user_id;
    private int rating;
    private String description;
    private String title;
}
