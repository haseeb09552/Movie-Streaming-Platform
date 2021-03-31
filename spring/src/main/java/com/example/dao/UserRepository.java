package com.example.demo.Repository;

import com.example.demo.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<com.example.demo.model.UserModel, Integer> {

    public UserModel findByEmail(String email);

    public UserModel findByEmailAndPassword(String email, String password);
    
}