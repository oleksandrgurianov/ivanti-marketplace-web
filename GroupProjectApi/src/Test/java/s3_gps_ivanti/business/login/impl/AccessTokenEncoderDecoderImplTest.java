package s3_gps_ivanti.business.login.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import s3_gps_ivanti.dto.login.AccessTokenDTO;

import java.security.Key;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccessTokenEncoderDecoderImplTest {

    @Mock
    private Key key;
    @InjectMocks
    private AccessTokenEncoderDecoderImpl accessTokenEncoderDecoder = new AccessTokenEncoderDecoderImpl("E91E158E4C6656F68B1B5D1C311766DE98D2AD6EF3BFB33F78E9CFCDF9");

    @Test
    void encode() {
        AccessTokenDTO token = AccessTokenDTO.builder()
                .subject("user")
                .roles(List.of("Customer"))
                .userID("id")
                .build();

        String actualResult = accessTokenEncoderDecoder.encode(token);

        String expectedResult = "eyJhbGciOiJIUzI1NiJ9.";

        assertEquals(expectedResult,actualResult.substring(0,21));
    }
    @Test
    void encode_NoUserID() {
        AccessTokenDTO token = AccessTokenDTO.builder()
                .subject("user")
                .roles(List.of("Customer"))
                .userID(null)
                .build();

        String actualResult = accessTokenEncoderDecoder.encode(token);

        String expectedResult = "eyJhbGciOiJIUzI1NiJ9.";

        assertEquals(expectedResult,actualResult.substring(0,21));
    }
    @Test
    void encode_NoRole() {
        AccessTokenDTO token = AccessTokenDTO.builder()
                .subject("user")
                .roles(null)
                .userID("id")
                .build();

        String actualResult = accessTokenEncoderDecoder.encode(token);

        String expectedResult = "eyJhbGciOiJIUzI1NiJ9.";

        assertEquals(expectedResult,actualResult.substring(0,21));
    }
    @Test
    void decode() {

        AccessTokenDTO expectedResult = AccessTokenDTO.builder()
                .subject("user")
                .roles(List.of("Customer"))
                .userID("id")
                .build();

        String encodedToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjU0NjI3NDM3LCJleHAiOjE2NTQ2MjkyMzcsInJvbGVzIjpbIkN1c3RvbWVyIl0sInVzZXJJRCI6ImlkIn0.neVdfI5UaMpr6qqoV9lp1grKttMbys9F2sPTvUkAyUU";

        AccessTokenDTO actualResult = accessTokenEncoderDecoder.decode(encodedToken);

        assertEquals(expectedResult, actualResult);
    }
}