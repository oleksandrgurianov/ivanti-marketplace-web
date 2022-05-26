package s3_gps_ivanti.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Review")
public class Review {

    @Id
    private ObjectId id;

    @DocumentReference(lookup = "{ 'id' : ?#{customer} }")
    private User customer;
    private ObjectId applicationId;
    
    private int rating;
    private String title;
    private String description;
    private Response response;
}
