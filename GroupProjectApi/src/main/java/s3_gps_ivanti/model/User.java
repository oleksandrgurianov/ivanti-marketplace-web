package s3_gps_ivanti.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Objects;

=======
>>>>>>> 7bc270fc16b87b024207014898503027e46b34d0
@Getter
@Setter
@Builder
@NoArgsConstructor
//@AllArgsConstructor

@Document("User")
public class User {
<<<<<<< HEAD
    @Id
    protected int id;
    protected String username;
    protected String password;
    protected String permission;


    public User(int id, String username, String password, String permission) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
    }
=======
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
>>>>>>> 7bc270fc16b87b024207014898503027e46b34d0

    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //TRY MONGODB
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getPermission() {
        return permission;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }

=======
    public User(int id, String username, String password, String firstName, String lastName){
        this.id = id;
        this.username= username;
        this.password=password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
>>>>>>> 7bc270fc16b87b024207014898503027e46b34d0
}
