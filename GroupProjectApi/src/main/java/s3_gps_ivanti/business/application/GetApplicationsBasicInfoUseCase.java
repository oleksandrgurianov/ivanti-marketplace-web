package s3_gps_ivanti.business.application;

import s3_gps_ivanti.dto.application.GetAllApplicationsResponseDTO;

public interface GetApplicationsBasicInfoUseCase {
    GetAllApplicationsResponseDTO getAllApplications();

//    List<ApplicationBasicInfoDTO> getApplications();
}
