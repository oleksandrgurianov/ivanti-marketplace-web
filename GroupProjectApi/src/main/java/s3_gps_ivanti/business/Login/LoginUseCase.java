package s3_gps_ivanti.business.Login;


import s3_gps_ivanti.dto.Login.LoginRequestDTO;
import s3_gps_ivanti.dto.Login.LoginResponseDTO;

public interface LoginUseCase {
    LoginResponseDTO login(LoginRequestDTO loginRequest);
}
