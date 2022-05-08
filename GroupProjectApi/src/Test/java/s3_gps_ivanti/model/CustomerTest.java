package s3_gps_ivanti.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void ConstructorBasedOn1Int4String2Lists() {

        ArrayList<Application> myApplications = new ArrayList<>();
        ArrayList<Review> myReviews = new ArrayList<>();

        Customer Customer = new Customer(1, "username","password",myReviews,myApplications ,"firstname","lastname");

        assertEquals(1, Customer.getId());
        assertEquals("username", Customer.getUsername());
        assertEquals("password", Customer.getPassword());
        assertEquals("firstname", Customer.getFirstName());
        assertEquals("lastname", Customer.getLastName());
        assertEquals(myApplications, Customer.getDownloadedApplications());
        assertEquals(myReviews, Customer.getMyReviews());
    }

    @Test
    void ConstructorBasedOn1Int2String() {

        Customer result = new Customer(1, "username", "password");

        assertEquals(1, result.getId());
        assertEquals("username", result.getUsername());
        assertEquals("password", result.getPassword());
    }
}