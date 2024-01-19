package com.maithen.authapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maithen.authapi.entity.User;
import com.maithen.authapi.repository.UserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean usernameExists(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void registerUser(User registrationRequest) {
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword())); 
        userRepository.save(user);
    }

}
