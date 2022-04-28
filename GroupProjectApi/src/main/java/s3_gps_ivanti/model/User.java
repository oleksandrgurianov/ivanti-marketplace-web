package s3_gps_ivanti.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
//@AllArgsConstructor

public class User {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(int id, String username, String password){
        this.id = id;
        this.username= username;
        this.password=password;
    }

    public User(int id, String username, String password, String firstName, String lastName){
        this.id = id;
        this.username= username;
        this.password=password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
