package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Creator extends User {

    private ArrayList<Application> MyApplications;
    private ArrayList<Response> MyResponses;

    public Creator(int id, String username, String password, String firstName, String lastName){
        super(id, username, password, firstName, lastName);
        MyApplications = new ArrayList<>();
        MyResponses = new ArrayList<>();
    }

    public Creator(int id, String username, String password, ArrayList<Application> myApplications, ArrayList<Response> myResponses, String firstName, String lastName)
    public Creator(int id, String username, String password, ArrayList<Application> myApplications, ArrayList<Response> myResponses)
    {
        super(id, username, password, firstName, lastName);
        super(id, username, password);
        this.MyApplications = myApplications;
        this.MyResponses = myResponses;
    }
    public Creator(int id, String username, String password){
        super(id, username, password);
        this.MyApplications = new ArrayList<>();
        this.MyResponses = new ArrayList<>();
    }
}