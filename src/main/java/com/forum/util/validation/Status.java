package com.forum.util.validation;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forum.configuration.constant.HttpConstant;
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
this.message = getCustomMessage(HttpStatus.valueOf(Integer.valueOf(code)));
}

public Status(String code, String message) {
	this.code = code;
	this.message = message;
}

public Status(HttpStatus httpStatus) {
	this.httpStatus = httpStatus;
	this.code = String.valueOf(httpStatus.value());
this.message = getCustomMessage(httpStatus);
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

@JsonIgnore
public boolean isSuccess() {
	return httpStatus.equals(HttpStatus.OK);
}

public String getCustomMessage (HttpStatus status) {
	switch (status) {
	case OK:
		return HttpConstant.MESSAGE_SUCCESS;
	case BAD_REQUEST:
		return HttpConstant.MESSAGE_BAD_REQUEST;
	case NOT_FOUND:
		return HttpConstant.MESSAGE_NOT_FOUND;
		default:
			return HttpConstant.MESSAGE_SERVER_ERROR;
	}
	}

}