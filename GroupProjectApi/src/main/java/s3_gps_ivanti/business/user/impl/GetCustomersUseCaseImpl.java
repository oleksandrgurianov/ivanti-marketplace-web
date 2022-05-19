package s3_gps_ivanti.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.user.GetCustomersUseCase;
import s3_gps_ivanti.repository.UserRepository;

@Service
@Primary
@RequiredArgsConstructor
public class GetCustomersUseCaseImpl implements GetCustomersUseCase {

    private final UserRepository userRepository;

}