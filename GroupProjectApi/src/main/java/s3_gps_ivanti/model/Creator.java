package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Creator extends User {

    private List<Application> myApplications;
    private List<Response> myResponses;

    public Creator(int id, String username, String password){
        super(id, username, password);
<<<<<<< HEAD
        this.MyApplications = new ArrayList<>();
        this.MyResponses = new ArrayList<>();
        }
=======
        this.myApplications = new ArrayList<>();
        this.myResponses = new ArrayList<>();
    }

    public Creator(int id, String username, String password, String firstName, String lastName){
        super(id, username, password, firstName, lastName);
        myApplications = new ArrayList<>();
        myResponses = new ArrayList<>();
    }

    public Creator(int id, String username, String password, List<Application> myApplications, List<Response> myResponses, String firstName, String lastName)
    {
        super(id, username, password, firstName, lastName);
        this.myApplications = myApplications;
        this.myResponses = myResponses;
    }
>>>>>>> 7bc270fc16b87b024207014898503027e46b34d0
}