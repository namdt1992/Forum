package com.forum.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HandleException {

	public HttpStatus toHttpStatus(Exception exception) {
		String exceptionName = exception.getClass().getName();
		switch (exceptionName) {
		case "DataAccessException":
			return HttpStatus.INTERNAL_SERVER_ERROR;
		case "ObjectNotFoundException":
			return HttpStatus.NOT_FOUND;
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
}