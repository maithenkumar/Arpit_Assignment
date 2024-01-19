package com.maithen.authapi.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        if ("user".equals(username)) {
            return User.builder()
                    .username("user")
                    .password("{bcrypt}$2a$10$uO8ZJzh8TFrV0I3R1peGlOdFG8rRQnPl0Y2fAeuoxz9goFCcwa77C") // Password is "password"
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
