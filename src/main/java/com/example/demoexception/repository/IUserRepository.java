package com.example.demoexception.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demoexception.model.dto.UserDTO;

public interface IUserRepository extends MongoRepository<UserDTO,String> {
	
	UserDTO findById(String id);

}
