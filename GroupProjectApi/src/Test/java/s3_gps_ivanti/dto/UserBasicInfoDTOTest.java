package s3_gps_ivanti.dto;

import org.junit.jupiter.api.Test;
import s3_gps_ivanti.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserBasicInfoDTOTest {

    @Test
    void ConstructorBasedOnUser() {

        User user = User.builder()
                .id(1)
                .firstName("firstName")
                .lastName("lastName")
                .password("password")
                .username("username")
                .build();

        UserBasicInfoDTO result = new UserBasicInfoDTO(user);

        assertEquals("firstName", result.getFirstName());
        assertEquals("lastName", result.getLastName());
        assertEquals(1, result.getId());
    }
}