package s3_gps_ivanti.business.application;

import s3_gps_ivanti.dto.version.VersionAnalyticsDTO;
import s3_gps_ivanti.repository.entity.User;

public interface GetApplicationAnalyticsUseCase {
    VersionAnalyticsDTO getVersion(String appName, double number);
    User getCreator(String name);
}
