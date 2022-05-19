package s3_gps_ivanti.business.version.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoConvertor.VersionDTOConverter;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.business.version.UpdateVersionUseCase;
import s3_gps_ivanti.dto.version.UpdateVersionRequestDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.Version;

@Service
@Primary
@RequiredArgsConstructor
public class UpdateVersionUseCaseImpl implements UpdateVersionUseCase {

    private final ApplicationRepository applicationRepository;


    @Override
    public void updateVersion(UpdateVersionRequestDTO version) {
        Application application = applicationRepository.findById(version.getApplicationID()).orElse(null);

        if(application == null) {
            throw new ApplicationNotFoundException();
        }

        for (Version v: application.getVersions()) {
            if(v.getNumber() == version.getNumber()){
                v = VersionDTOConverter.convertToEntityForUpdate(version,v);
            }
            break;
        }

        applicationRepository.save(application);
    }
}
