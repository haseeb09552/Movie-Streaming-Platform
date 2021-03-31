package com.example.demo.dao;

import com.example.demo.model.UserModel;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer>{

}
