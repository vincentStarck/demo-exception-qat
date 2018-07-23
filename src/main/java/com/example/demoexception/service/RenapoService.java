package com.example.demoexception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demoexception.exception.RenapoServiceException;
import com.example.demoexception.model.dto.RenapoDTO;

@Service
public class RenapoService implements IRenapoService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean validateCurp(String curp) throws RenapoServiceException {
		String url = "http://localhost:9092/curp";
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();		
		body.add("curp",curp);
		ResponseEntity<RenapoDTO> resp =null;
		try {
			resp = restTemplate.postForEntity(url, body, RenapoDTO.class);
		} catch (RestClientException e) {
			throw new RenapoServiceException("Error al invocar servicio RENAPO",e);
		} 
		if(resp==null) {
			throw new RenapoServiceException("La invocacion al servicio de RENAPO regresa null");
		}
		return resp.getBody().isCurpValid();
	}

}
