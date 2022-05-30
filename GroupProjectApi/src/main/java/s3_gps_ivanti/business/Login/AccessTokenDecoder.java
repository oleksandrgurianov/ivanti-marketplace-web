package s3_gps_ivanti.business.login;

import s3_gps_ivanti.dto.Login.AccessTokenDTO;

public interface AccessTokenDecoder {
    AccessTokenDTO decode(String accessTokenEncoded);
}
