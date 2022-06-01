package s3_gps_ivanti.business.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.application.CreateApplicationUseCase;
import s3_gps_ivanti.business.dtoconvertor.ApplicationDTOConverter;
import s3_gps_ivanti.business.exception.ApplicationNameNotUnique;
import s3_gps_ivanti.dto.application.CreateApplicationRequestDTO;
import s3_gps_ivanti.dto.application.CreateApplicationResponseDTO;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.Application;
import s3_gps_ivanti.repository.entity.User;

import javax.transaction.Transactional;


@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class CreateApplicationUseCaseImpl implements CreateApplicationUseCase {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    @Override
    public CreateApplicationResponseDTO createApplications(CreateApplicationRequestDTO applicationRequestDTO) {

        if(applicationRepository.findByName(applicationRequestDTO.getName()) != null)
        {
            throw new ApplicationNameNotUnique();
        }
        Application app = ApplicationDTOConverter.convertToEntity(applicationRequestDTO);
        User user = userRepository.findUserByUsername(applicationRequestDTO.getCreatorID());
        app.setCreator(user);
        applicationRepository.save(app);
        Application newApplication = applicationRepository.findByName(applicationRequestDTO.getName());
        return ApplicationDTOConverter.convertToDTOCreateResponse(newApplication);
    }
}
