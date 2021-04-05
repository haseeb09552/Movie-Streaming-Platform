package com.example.controller;

import com.example.entities.UserModel;
import com.example.services.Userservice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

	@Autowired
	private Userservice service;
	
	
	//To register a new user
	@PostMapping("/signup")
	@CrossOrigin
	public Boolean saveUser(@RequestBody UserModel user) throws Exception {
		String tempEmail = user.getEmail();
		if(tempEmail!=null && !"".equals(tempEmail)) {
			UserModel obj = service.fetchUserByEmail(tempEmail);
			if(obj!=null) {
				throw new Exception("Bad Credentials");
			}
		}
		service.saveUser(user);
		return true;
	}

	
	  //Used to login
	  @PostMapping("/login")
	  public Boolean loginUser(@RequestBody UserModel user)throws Exception { 
		  String tempEmail = user.getEmail();
		  String tempPass = user.getPassword();
		  UserModel userObj = null; if(tempEmail!=null && tempPass!=null) { 
			  userObj = service.fetchUserByEmailAndPassword(tempEmail,tempPass); 
			  userObj.setActive(true); 
			  service.saveUser(userObj); 
			}
		if(userObj==null) { 
			throw new Exception("Bad Credentials");
		} 
		return true; 
	}
	 
	
	  //Used to logout
	  @GetMapping(value = "/logout") 
	  public Boolean logout_user(@RequestBody UserModel user,HttpSession session){ 
		  session.removeAttribute("username"); 
		  session.invalidate();
		  String tempEmail = user.getEmail();
		  String tempPass = user.getPassword();
		  UserModel userObj = null; 
		  if(tempEmail!=null && tempPass!=null) { 
			  userObj = service.fetchUserByEmailAndPassword(tempEmail,tempPass); 
			  userObj.setActive(false); 
			  service.saveUser(userObj);
			  return true;
		  }
		  
		  return false;
	  }
}