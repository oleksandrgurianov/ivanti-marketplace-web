package com.example.Individual_Project.business;

import com.example.Individual_Project.model.User;
import com.example.Individual_Project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User getUser(String username, String password) {
        return userRepository.getUser(username, password);
    }
}
