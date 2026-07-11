package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }
}
