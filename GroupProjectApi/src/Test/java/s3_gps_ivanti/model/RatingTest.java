package s3_gps_ivanti.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {
    @Test
    void totalAmount() {

        Rating rating = new Rating(1,24,12,12,12,0);

        double result = rating.totalAmount();

        assertEquals(60, result);
    }
    @Test
    void avgStar() {

        Rating rating = new Rating(1,12,12,12,12,50);

        double result = rating.avgStar();

        assertEquals(3, result);
    }
}