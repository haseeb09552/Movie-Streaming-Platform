package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.LoginModel;
import com.example.services.JwtUtil;

@RestController
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public String checkUser(LoginModel authRequest) throws Exception {
		 try {
	            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        return jwtUtil.generateToken(authRequest.getEmail());
	}
	
}
