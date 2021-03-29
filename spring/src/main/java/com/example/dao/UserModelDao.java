package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.UserModel;

@Repository
public interface UserModelDao extends JpaRepository<UserModel, String>{

	static UserModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
