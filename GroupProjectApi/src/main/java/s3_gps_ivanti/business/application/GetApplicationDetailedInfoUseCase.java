package s3_gps_ivanti.business.application;

import s3_gps_ivanti.dto.application.ApplicationDetailedInfoDTO;

import java.util.Optional;

public interface GetApplicationDetailedInfoUseCase {

    ApplicationDetailedInfoDTO getApplicationInfo(String name);

//    Optional<ApplicationDetailedInfoDTO> getApplicationDetailedInfo(String name);
}
