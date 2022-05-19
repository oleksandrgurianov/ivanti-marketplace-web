package s3_gps_ivanti.business.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.application.DeleteApplicationUseCase;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.entity.Application;

@Service
@Primary
@RequiredArgsConstructor
public class DeleteApplicationUseCaseImpl implements DeleteApplicationUseCase {

    private final ApplicationRepository applicationRepository;

    @Override
    public void deleteApplications(String id) {

        Application application = applicationRepository.findById(id).orElse(null);

        if(application == null) {
            throw new ApplicationNotFoundException();
        }

        application.setStatus(true);

        applicationRepository.save(application);
    }
}
