package s3_gps_ivanti.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("User")
public class User {

    @Id
    protected String id;
    private String username;
    private String email;
    private String password;
    private List<String> roles;
    private String permission;
}
