package com.example.Individual_Project.business;

import com.example.Individual_Project.model.Review;
import com.example.Individual_Project.model.User;

public interface UserService {

    User getUser(String username, String password);
}
