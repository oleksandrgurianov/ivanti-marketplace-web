package s3_gps_ivanti.model;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor

public class User {
    protected int id;
    protected String username;
    protected String password;

    public User(String username, String password){
        super();
        this.username= username;
        this.password=password;
    }

    public long getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

}
