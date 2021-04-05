package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.el.MethodNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserModelDao;
import com.example.entities.UserModel;

@RestController
public class UserController {

//	@Autowired
//	private UserModelService userModelService;
	@Autowired
	private UserModelDao userModelDao;
	
	//For admin to fetch all the registered users
	@GetMapping("/admin")
	public List<UserModel> getUser(){
		List<UserModel> userModel = new ArrayList<>();
		this.userModelDao.findAll()
				.forEach(userModel::add);
		return userModel;
	}
	
	//For admin to fetch registered user based on user id
	@GetMapping("/admin/{id}")
	public Optional<UserModel> userEditData(@PathVariable String id){
		if(this.userModelDao.existsById(id)) {
			return this.userModelDao.findById(id);
		}
		return null;
	}
	
	//For admin to edit registered user details based on user id
	@PutMapping("/admin/userEdit/{id}")
	public  void userEditSave(@RequestBody final UserModel data) {
		if(this.userModelDao.existsById(data.getId())) {
			this.userModelDao.save(data);
		}
	}

	//For admin to delete registered user based on user id
	@DeleteMapping("/admin/delete/{id}")
	public void userDelete (@PathVariable String id){
		if(this.userModelDao.existsById(id)) {
		this.userModelDao.deleteById(id);
		}
	}
	

	//Exception Handling
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public String illegalArgumentExceptionHandler(Model m) {
		m.addAttribute("msg", "Illegal input");
		return "error_page";
	}
	@ExceptionHandler(value = MethodNotFoundException.class)
	public String methodNotFoundExceptionHandler(Model m) {
		m.addAttribute("msg", "method not allowed");
		return "error_page";
	}
	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerExceptionHandler(Model m) {
		m.addAttribute("msg", "Input can't be empty");
		return "error_page";
	}
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Model m) {
		m.addAttribute("msg", "Error has Occured");
		return "error_page";
	}
}
