package s3_gps_ivanti.business.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.application.GetApplicationAnalyticsUseCase;
import s3_gps_ivanti.business.dtoconvertor.VersionDTOConverter;
import s3_gps_ivanti.dto.version.VersionAnalyticsDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.User;
import s3_gps_ivanti.repository.entity.Version;

import javax.transaction.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class GetApplicationAnalyticsUseCaseImpl implements GetApplicationAnalyticsUseCase {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public VersionAnalyticsDTO getVersion(String appName, double number){
        Application app = applicationRepository.findByName(appName);

        for (Version v: app.getVersions()){
            if(v.getNumber() == number){
                return VersionDTOConverter.convertToDTOForAnalytics(v);
            }
        }
        return null;
    }
    public User getCreator(String name){
        return userRepository.findUserByUsername(name);
    }
}
