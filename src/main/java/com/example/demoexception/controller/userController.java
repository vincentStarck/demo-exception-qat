package com.example.demoexception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoexception.exception.UserCurpException;
import com.example.demoexception.exception.UserNotFoundException;
import com.example.demoexception.model.dto.UserDTO;
import com.example.demoexception.service.IUserService;

@RequestMapping("/api/user/")
@RestController
public class userController {
	
	@Autowired
	private IUserService userService;
	

	@GetMapping("/{id}")
	public HttpEntity<UserDTO> getUserById(@PathVariable String id) throws UserNotFoundException {	
		return new HttpEntity<UserDTO>(userService.getUserById(id));
	}
	
	@PostMapping()
	public  HttpEntity<UserDTO> addUser(@RequestBody UserDTO userDTO )throws UserCurpException {
		UserDTO user = userService.addUser(userDTO);
		return new HttpEntity<UserDTO>(user);
	}

}
