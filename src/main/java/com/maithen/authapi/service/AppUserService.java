package com.maithen.authapi.service;

import com.maithen.authapi.entity.User;

public interface AppUserService {

    boolean usernameExists(String username);

    boolean emailExists(String email);

    void registerUser(User registrationRequest);

}
