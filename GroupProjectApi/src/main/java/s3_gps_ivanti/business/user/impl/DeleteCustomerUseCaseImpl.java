package s3_gps_ivanti.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.user.CreateCustomerUseCase;
import s3_gps_ivanti.business.user.DeleteCustomerUseCase;
import s3_gps_ivanti.repository.UserRepository;

@Service
@Primary
@RequiredArgsConstructor
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private final UserRepository userRepository;

}
