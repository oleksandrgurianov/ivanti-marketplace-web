package s3_gps_ivanti.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor

@Document("User")
public class User {
    @Id
    protected int id;
    protected String username;
    protected String password;
    protected String permission;
    protected int code;

    public User(int id, String username, String password, String permission, int code) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.code = code;
    }

    public User(int id, String username, String password){
        super();
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


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public int getUserCode() {
        return code;
    }
    public void setUserCode(int code) {
        this.code = code;
    }
    public void incrementCode(int code) {
        this.code = code++;
    }

    public String getPermission() {
        return permission;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }
}
