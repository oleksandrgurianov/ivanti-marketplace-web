package s3_gps_ivanti.business.application;

import s3_gps_ivanti.dto.application.ApplicationBasicInfoDTO;

import java.util.List;

public interface GetApplicationsBasicInfoUseCase {

    List<ApplicationBasicInfoDTO> getApplications();
}
