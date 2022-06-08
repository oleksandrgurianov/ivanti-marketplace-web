package s3_gps_ivanti.business.application;

import s3_gps_ivanti.dto.version.VersionAnalyticsRequestDTO;
import s3_gps_ivanti.dto.version.VersionAnalyticsResponseDTO;

public interface GetVersionAnalyticsPerMonthUseCase {
    VersionAnalyticsResponseDTO getVersionAnalytics(VersionAnalyticsRequestDTO request);
}
