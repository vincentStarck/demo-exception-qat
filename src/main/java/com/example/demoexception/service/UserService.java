package com.example.demoexception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoexception.exception.RenapoServiceException;
import com.example.demoexception.exception.UserCurpException;
import com.example.demoexception.exception.UserNotFoundException;
import com.example.demoexception.model.dto.UserDTO;
import com.example.demoexception.repository.IUserRepository;


@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired 
	private IRenapoService renapoService;

	@Override
	public UserDTO getUserById(String id) throws UserNotFoundException {
		UserDTO user = userRepository.findById(id);
		if(user==null) {
			throw new UserNotFoundException("Usuario con id: "+id+" no encontrado");
		}
		return user;
	}

	@Override
	public UserDTO addUser(UserDTO userDTO) throws UserCurpException{	
		boolean isCurpValid=false;
		try {
			isCurpValid = renapoService.validateCurp(userDTO.getCurp());
		} catch (RenapoServiceException e) {			
			throw new UserCurpException("No fue posible validar curp en renapo",e);
		}
		
		if(!isCurpValid) {
			throw new UserCurpException("Curp no valida");
		}
			
		return  userRepository.save(userDTO);	
		
	}

}
