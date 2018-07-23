package com.example.demoexception.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demoexceptionlib.model.BaseErrorDTO;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * @author C037695
 *Manejador para las excepciones de negocio del proyecto demoException
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

	/**
	 * variable para dar formato a fecha
	 */
	private SimpleDateFormat dataFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	
	/**
	 * Handle UserNotFoundException
	 *
	 **/
	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<BaseErrorDTO> handleUserException(UserNotFoundException ex) {

		BaseErrorDTO baseError = BaseErrorDTO.builder()
				.message(ex.getMessage())
				.timestamp(dataFormat.format(new Date())).build();
		log.error("Usuario no encontrado: ", ex);
		return new ResponseEntity<BaseErrorDTO>(baseError, NOT_FOUND);

	}

	/**
	 * Handle UserCurpException
	 *
	 **/
	@ExceptionHandler(UserCurpException.class)
	protected ResponseEntity<BaseErrorDTO> handleUserCurpException(UserCurpException ex) {

		BaseErrorDTO baseError = BaseErrorDTO.builder()
				.message(ex.getMessage())
				.timestamp(dataFormat.format(new Date())).build();
		log.error("Error al validar curp: ", ex);
		return new ResponseEntity<BaseErrorDTO>(baseError, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
