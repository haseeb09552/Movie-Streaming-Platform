package com.example.dao;

import com.example.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<com.example.entities.UserModel, Integer> {

    public UserModel findByEmail(String email);

    public UserModel findByEmailAndPassword(String email, String password);
    
}
