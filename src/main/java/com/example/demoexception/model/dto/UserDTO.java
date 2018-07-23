package com.example.demoexception.model.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author C037695
 *
 */
@Data
@Builder
@ToString
@AllArgsConstructor
public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	/**
	 * user name
	 */
	private String name;
	
	/**
	 * user email
	 */
	private String email;
	
	private String curp;
	
	public UserDTO() {
		
	}
	

}
