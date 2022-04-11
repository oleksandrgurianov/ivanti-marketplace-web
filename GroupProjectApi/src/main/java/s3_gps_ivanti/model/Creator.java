package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class Creator extends User {

    private ArrayList<Application> MyApplications;
    private ArrayList<Response> MyResponses;

    public Creator(String username, String password, ArrayList<Application> myApplications, ArrayList<Response> myResponses)
    {
        super(username, password);
        this.MyApplications = myApplications;
       this.MyResponses = myResponses;
    }
    public Creator(String username, String password){
        super(username, password);
        this.username= username;
        this.password = password;
    }
}