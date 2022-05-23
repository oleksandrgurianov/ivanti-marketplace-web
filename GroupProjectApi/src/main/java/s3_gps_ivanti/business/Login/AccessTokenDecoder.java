package s3_gps_ivanti.business.Login;

import s3_gps_ivanti.dto.Login.AccessTokenDTO;

public interface AccessTokenDecoder {
    AccessTokenDTO decode(String accessTokenEncoded);
}
