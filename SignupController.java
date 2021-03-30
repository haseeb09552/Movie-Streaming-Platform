package com.example.demo.controller;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SignupController {
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/signup")
    public Boolean saveuser(@RequestBody UserModel user) {
        if(userRepository.save(user) != null) {
            return true;
        }
        return false;
    }

}
