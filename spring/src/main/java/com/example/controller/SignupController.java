package com.example.controller;

import com.example.entities.*;
import com.example.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

	@Autowired
	private Userservice service;

	@PostMapping("/signup")
	@CrossOrigin
	public UserModel saveUser(@RequestBody UserModel user) throws Exception {
		String tempEmail = user.getEmail();
		if(tempEmail!=null && !"".equals(tempEmail)) {
			UserModel obj = service.fetchUserByEmail(tempEmail);
			if(obj!=null) {
				throw new Exception("User with "+tempEmail+ " already exists!!");
			}
		}
		UserModel userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
    @PostMapping("/login")
	@CrossOrigin
	public UserModel loginUser(@RequestBody UserModel user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPass = user.getPassword();
		UserModel userObj = null;
		if(tempEmail!=null && tempPass!=null) {
			userObj = service.fetchUserByEmailAndPassword(tempEmail, tempPass);
		}
		if(userObj==null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
}
