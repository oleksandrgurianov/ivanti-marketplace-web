package s3_gps_ivanti.business.version.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoconvertor.VersionDTOConverter;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.business.exception.InvalidCredentialsException;
import s3_gps_ivanti.business.exception.VersionNumberIncorrectException;
import s3_gps_ivanti.business.version.CreateMinorVersionUseCase;
import s3_gps_ivanti.business.version.GetLatestVersionUseCase;
import s3_gps_ivanti.dto.login.AccessTokenDTO;
import s3_gps_ivanti.dto.version.CreateMinorVersionRequestDTO;
import s3_gps_ivanti.dto.version.CreateMinorVersionResponseDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.Version;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class CreateMinorVersionUseCaseImpl implements CreateMinorVersionUseCase {

    private final ApplicationRepository applicationRepository;
    private final GetLatestVersionUseCase getLatestVersion;
    private final AccessTokenDTO requestAccessToken;

    @Override
    public CreateMinorVersionResponseDTO createVersion(CreateMinorVersionRequestDTO versionRequestDTO) {

        Application application = applicationRepository.findById(versionRequestDTO.getApplicationID()).orElse(null);

        if(application == null) {
            throw new ApplicationNotFoundException();
        }

        if(!requestAccessToken.getUserID().equals(application.getCreator().getId())){
            throw new InvalidCredentialsException();
        }

        Version latestVersion = getLatestVersion.getLatestVersion(application);

        DecimalFormat df = new DecimalFormat("###.##");

        double nextVersion = latestVersion.getNumber() + 0.1;

        nextVersion = Double.parseDouble(df.format(nextVersion));

        if(nextVersion != versionRequestDTO.getNumber()){
            throw new VersionNumberIncorrectException();
        }

        List<Version> newVersions = new ArrayList<>(application.getVersions());
        Version version = VersionDTOConverter.convertToEntityForCreate(versionRequestDTO);
        newVersions.add(version);
        application.setVersions(newVersions);

        applicationRepository.save(application);

        return VersionDTOConverter.convertToDTOForMinorResponse(version);
    }
}
