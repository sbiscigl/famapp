package org.sigco.famapp.controller;

import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public NotFoundException notFoundException(NotFoundException exception) {
		return exception;
	}

	@ExceptionHandler(value = ConflictException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ResponseBody
	public ConflictException conflictException(ConflictException exception) {
		return exception;
	}
}

