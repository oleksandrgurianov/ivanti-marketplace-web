package s3_gps_ivanti.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {
    @Test
    void ConstructorBasedOnNothing() {

        Response response = new Response();

        assertNotNull(response);
    }
}