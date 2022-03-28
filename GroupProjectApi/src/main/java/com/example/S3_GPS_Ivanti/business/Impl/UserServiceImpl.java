package com.example.S3_GPS_Ivanti.business.Impl;

import com.example.S3_GPS_Ivanti.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(String username, String password) {
        return userRepository.getUser(username, password);
    }
}
