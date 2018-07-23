package com.example.demoexception.service;

import com.example.demoexception.exception.UserCurpException;
import com.example.demoexception.exception.UserNotFoundException;
import com.example.demoexception.model.dto.UserDTO;

public interface IUserService {
	
	UserDTO getUserById(String id) throws UserNotFoundException;
	
	UserDTO addUser(UserDTO userDTO)throws UserCurpException;
	
    
	

}
