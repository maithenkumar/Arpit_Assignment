package com.maithen.authapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maithen.authapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean findByEmail(String username);

    // Optional<User> findByUsername(String username);
    // Optional<User> findByEmail(String email);
    // Optional<User> existsById(long id );

}
