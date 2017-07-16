package com.forum.util.validation;

import com.forum.service.AbstractService;

/**
 * @author nam
 *
 */
public class Status extends AbstractService {
private String code, message;

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

}