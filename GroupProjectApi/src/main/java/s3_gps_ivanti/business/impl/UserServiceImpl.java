package s3_gps_ivanti.business.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import s3_gps_ivanti.business.UserService;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.repository.UserRepository;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByID(int id) {
        return userRepository.getUserById(id);
    }
}
