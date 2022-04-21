package s3_gps_ivanti.model;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor

public class User {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    protected int id;
    protected String username;
    protected String password;

    public User(int id, String username, String password){
        super();
        this.id = id;
        this.username= username;
        this.password=password;
    }
}
