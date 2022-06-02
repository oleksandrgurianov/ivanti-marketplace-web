package s3_gps_ivanti.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.user.GetCreatorUseCase;
import s3_gps_ivanti.repository.UserRepository;
import s3_gps_ivanti.repository.entity.User;

import javax.transaction.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class GetCreatorUseCaseImpl implements GetCreatorUseCase {
    private final UserRepository userRepository;

    @Override
    public User getCreator(String name) {
        return userRepository.findUserByUsername(name);
    }
}
