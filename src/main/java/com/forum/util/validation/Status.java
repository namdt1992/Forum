package com.forum.util.validation;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forum.service.AbstractService;

/**
 * @author nam
 *
 */
public class Status extends AbstractService {
private String code, message;
private HttpStatus httpStatus;

public Status() {
}

public Status (String code) {
	this.code = code;
	this.message = findMessageByCode(code);
}

public Status(String code, String message) {
	this.code = code;
	this.message = message;
}

public Status(HttpStatus httpStatus) {
	this.httpStatus = httpStatus;
	code = String.valueOf(httpStatus.value());
	message = findMessageByCode(code);
}


public Status(HttpStatus httpStatus, String message) {
	this.httpStatus = httpStatus;
	code = String.valueOf(httpStatus.value());
	this.message = message;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

@JsonIgnore
public HttpStatus getHttpStatus() {
	return httpStatus;
}

}