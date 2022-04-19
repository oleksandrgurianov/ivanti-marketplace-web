package s3_gps_ivanti.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
