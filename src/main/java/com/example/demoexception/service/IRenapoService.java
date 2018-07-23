package com.example.demoexception.service;

import com.example.demoexception.exception.RenapoServiceException;

public interface IRenapoService {
	
	boolean validateCurp(String curp)throws RenapoServiceException;

}
