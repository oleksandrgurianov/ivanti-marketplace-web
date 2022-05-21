package s3_gps_ivanti.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.dtoConvertor.CustomerDTOConverter;
import s3_gps_ivanti.business.exception.EmailAlreadyExistsException;
import s3_gps_ivanti.business.exception.UsernameAlreadyExistsException;
import s3_gps_ivanti.business.user.CreateCustomerUseCase;
import s3_gps_ivanti.dto.user.CreateCustomerRequestDTO;
import s3_gps_ivanti.dto.user.CreateCustomerResponseDTO;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.User;

@Service
@Primary
@RequiredArgsConstructor
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final UserRepository userRepository;

    @Override
    public CreateCustomerResponseDTO createCustomer(CreateCustomerRequestDTO customerRequestDTO) {

        if(userRepository.findUserByUsername(customerRequestDTO.getUsername()) != null) {
            throw new UsernameAlreadyExistsException();
        }

        if(userRepository.findUserByEmail(customerRequestDTO.getUsername()) != null) {
            throw new EmailAlreadyExistsException();
        }

        User user = CustomerDTOConverter.ConvertToEntity(customerRequestDTO);

        userRepository.save(user);

        return CustomerDTOConverter.ConvertToDTOCreateResponse(user);
    }
}
