package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Data
public class Creator extends User {

    private ArrayList<Application> MyApplications;
    private ArrayList<Response> MyResponses;

    public Creator(int id, String username, String password, ArrayList<Application> myApplications, ArrayList<Response> myResponses)
    {
        super(id, username, password);
        this.MyApplications = myApplications;
       this.MyResponses = myResponses;
    }
}