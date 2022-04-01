package S3_GPS_Ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Data
public class Creator extends User{

    private ArrayList<Application> MyApplications;
    private ArrayList<Response> MyResponses;

    public Creator(String username,String password,ArrayList<Application> myApplications, ArrayList<Response> myResponses)
    {
        super(username, password);
        this.MyApplications = myApplications;
       this.MyResponses = myResponses;
    }
}