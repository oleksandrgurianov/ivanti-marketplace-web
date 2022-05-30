package s3_gps_ivanti.business.Login;


import s3_gps_ivanti.dto.Login.AccessTokenDTO;

public interface AccessTokenEncoder {
    String encode(AccessTokenDTO accessTokenDTO);
}
