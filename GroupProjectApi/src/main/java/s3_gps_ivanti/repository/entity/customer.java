package s3_gps_ivanti.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Customer")
public class customer extends user {

    @Id
    protected int id;
    private user user;
    private List<String> appsDownloaded;
}
