package s3_gps_ivanti.business.application;

import s3_gps_ivanti.dto.application.ApplicationBasicInfoDTO;
import s3_gps_ivanti.dto.application.GetAllApplicationsResponseDTO;

import java.util.List;

public interface GetApplicationsBasicInfoUseCase {
    GetAllApplicationsResponseDTO getAllApplications();

//    List<ApplicationBasicInfoDTO> getApplications();
}
