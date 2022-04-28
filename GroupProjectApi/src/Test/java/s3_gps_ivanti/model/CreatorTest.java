package s3_gps_ivanti.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CreatorTest {

    @Test
    void ConstructorBasedOn1Int4String() {

        Creator creator = new Creator(1, "username","password", "firstname","lastname");

        assertEquals(1, creator.getId());
        assertEquals("username", creator.getUsername());
        assertEquals("password", creator.getPassword());
        assertEquals("firstname", creator.getFirstName());
        assertEquals("lastname", creator.getLastName());
    }

    @Test
    void ConstructorBasedOn1Int4String2Lists() {
        ArrayList<Application> myApplications = new ArrayList<>();
        ArrayList<Response> myResponses = new ArrayList<>();

        Creator creator = new Creator(1, "username","password", myApplications,myResponses ,"firstname","lastname");

        assertEquals(1, creator.getId());
        assertEquals("username", creator.getUsername());
        assertEquals("password", creator.getPassword());
        assertEquals("firstname", creator.getFirstName());
        assertEquals("lastname", creator.getLastName());
        assertEquals(myApplications, creator.getMyApplications());
        assertEquals(myResponses, creator.getMyResponses());
    }
}