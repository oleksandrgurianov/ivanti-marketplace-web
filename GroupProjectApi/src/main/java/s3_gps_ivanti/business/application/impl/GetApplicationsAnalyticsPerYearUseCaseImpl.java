package s3_gps_ivanti.business.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import s3_gps_ivanti.business.application.GetApplicationsAnalyticsPerYearUseCase;
import s3_gps_ivanti.business.dtoconvertor.ApplicationDTOConverter;
import s3_gps_ivanti.dto.application.ApplicationAnalyticsRequestDTO;
import s3_gps_ivanti.dto.application.ApplicationAnalyticsResponseDTO;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.DownloadsPerMonth;
import s3_gps_ivanti.repository.entity.User;
import s3_gps_ivanti.repository.entity.Version;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class GetApplicationsAnalyticsPerYearUseCaseImpl implements GetApplicationsAnalyticsPerYearUseCase {
    private final UserRepository userRepository;

    private List<DownloadsPerMonth> getDownloadAnalyticsPerApp(Application app, int year) {
        List<DownloadsPerMonth> downloadsAnalytics = new ArrayList<>();

        for (DownloadsPerMonth download : app.getDownloads()){
            if(download.getYear()==year){
                downloadsAnalytics.add(download);
            }
        }
        return downloadsAnalytics;
    }

    @Override
    public List<ApplicationAnalyticsResponseDTO> getApplicationAnalytics(ApplicationAnalyticsRequestDTO request) {
        User creator = userRepository.findUserByUsername(request.getCreatorName());
        List<ApplicationAnalyticsResponseDTO> applicationAnalytics = new ArrayList<>();
        LocalDate date = LocalDate.now();

        if(StringUtils.hasText(String.valueOf(request.getYear()))){
            for (Application app : creator.getApplications()){
                ApplicationAnalyticsResponseDTO appAnalytics = ApplicationDTOConverter.convertToDTOForAnalytics(app);
                appAnalytics.setDownloads(getDownloadAnalyticsPerApp(app, request.getYear()));

                applicationAnalytics.add(appAnalytics);
            }
        }
        else
        for (Application app : creator.getApplications()){
            ApplicationAnalyticsResponseDTO appAnalytics = ApplicationDTOConverter.convertToDTOForAnalytics(app);
            appAnalytics.setDownloads(getDownloadAnalyticsPerApp(app, date.getYear()));

            applicationAnalytics.add(appAnalytics);
        }

        return applicationAnalytics;
    }

    public List<DownloadsPerMonth> getDownloadAnalyticsPerVersion(Version version, int year){
        List<DownloadsPerMonth> downloadsAnalytics = new ArrayList<>();

        for (DownloadsPerMonth download : version.getDownloads()){
            if(download.getYear()==year){
                downloadsAnalytics.add(download);
            }
        }
        return downloadsAnalytics;
    }
}
