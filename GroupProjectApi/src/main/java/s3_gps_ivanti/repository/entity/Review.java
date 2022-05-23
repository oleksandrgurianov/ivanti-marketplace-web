package s3_gps_ivanti.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Review")
public class Review {

    @Id
    private String id;
    private String customerID;
    private String applicationID;
    private int rating;
    private String title;
    private String description;
    private Response response;
}
