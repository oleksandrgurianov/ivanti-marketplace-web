package com.example.Individual_Project.repository;

import com.example.Individual_Project.model.User;

public interface UserRepository  {
    User getUser(String username, String password);
}
