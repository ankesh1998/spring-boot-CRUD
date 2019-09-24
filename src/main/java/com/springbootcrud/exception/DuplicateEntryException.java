package com.springbootcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DuplicateEntryException extends RuntimeException {

	public DuplicateEntryException(String exception) {
		super(exception);
	}
}
