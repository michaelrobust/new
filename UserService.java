package com.example.restaurant.service;

import com.example.restaurant.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String registerUser(User user) {
        // Implement user registration logic
        return "User registered successfully";
    }

    public String loginUser(User user) {
        // Implement user login logic
        return "User logged in successfully";
    }
}
