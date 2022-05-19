package s3_gps_ivanti.business.version;

import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.Version;

public interface GetLatestVersion {
    Version getLatestVersion(Application application);
}
