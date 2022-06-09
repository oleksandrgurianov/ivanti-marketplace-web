package s3_gps_ivanti.business.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import s3_gps_ivanti.business.application.GetVersionAnalyticsPerMonthUseCase;
import s3_gps_ivanti.dto.version.VersionAnalyticsRequestDTO;
import s3_gps_ivanti.dto.version.VersionAnalyticsResponseDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.entity.DownloadsPerMonth;
import s3_gps_ivanti.repository.entity.Version;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class GetVersionAnalyticsPerMonthUseCaseImpl implements GetVersionAnalyticsPerMonthUseCase {
    private final ApplicationRepository applicationRepository;

    @Override
    public VersionAnalyticsResponseDTO getVersionAnalytics(VersionAnalyticsRequestDTO request) {
        Version version = getVersion(request.getApp(), request.getNumber());
        LocalDate date = LocalDate.now();

        if(StringUtils.hasText(String.valueOf(request.getYear()))){
            return versionAnalyticsResponse(version, request.getNumber(), request.getYear());
        }

        return versionAnalyticsResponse(version, request.getNumber(), date.getYear());
    }

    private VersionAnalyticsResponseDTO versionAnalyticsResponse(Version version, double number, int year){
        VersionAnalyticsResponseDTO versionAnalytics = VersionAnalyticsResponseDTO.builder()
                .number(number)
                .downloads(getDownloadAnalyticsPerVersion(version, year))
                .totalDownloads(totalDownloadPerYear(year, version))
                .build();

        versionAnalytics.setDownloads(getDownloadAnalyticsPerVersion(version, year));
        versionAnalytics.setTotalDownloads(totalDownloadPerYear(year, version));

        return versionAnalytics;
    }
    private Version getVersion(String app, double number){
        for(Version version : applicationRepository.findByName(app).getVersions()){
            if(version.getNumber() == number){
                return version;
            }
        }
        return null;
    }
    private List<DownloadsPerMonth> getDownloadAnalyticsPerVersion(Version version, int year) {
        List<DownloadsPerMonth> downloadsAnalytics = new ArrayList<>();

        for (DownloadsPerMonth download : version.getDownloads()){
            if(download.getYear()==year){
                downloadsAnalytics.add(download);
            }
        }
        return downloadsAnalytics;
    }
    private int totalDownloadPerYear(int year, Version version){
        int amount = 0;

        for (DownloadsPerMonth downloads : getDownloadAnalyticsPerVersion(version, year)){
            amount+=downloads.getAmount();
        }
        return amount;
    }
}
