package s3_gps_ivanti.business.version.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.exception.ApplicationHasNoVersionException;
import s3_gps_ivanti.business.version.GetLatestVersion;
import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.Version;


@Service
@Primary
@RequiredArgsConstructor
public class GetLatestVersionImpl implements GetLatestVersion {
    @Override
    public Version getLatestVersion(Application application) {

        if(application.getVersions().size() <= 0){
            throw new ApplicationHasNoVersionException();
        }

        Version result = new Version();

        for (Version v: application.getVersions()) {
            if(v.getNumber() > result.getNumber())
            {
                result = v;
            }
        }
        return result;
    }
}
