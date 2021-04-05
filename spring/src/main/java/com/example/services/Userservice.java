package com.example.services;

import com.example.dao.UserModelDao;
import com.example.entities.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice {
    @Autowired
    private UserModelDao repo;



    public UserModel saveUser(UserModel user) {

        return repo.save(user);
    }

    public UserModel fetchUserByEmail(String email) {
        return repo.findByEmail(email);
    }

    public UserModel fetchUserByEmailAndPassword(String email, String password) {
        return repo.findByEmailAndPassword(email,password);
    }

}