package s3_gps_ivanti.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private Long id;
    private Long application_ID;
    private Long user_ID;
    private int rating;
    private String description;
    private String title;
}
