package com.forum.util.validation;

/**
 * @author nam
 *
 */
public class ValidationStatus {
private String code, message;


public ValidationStatus(String code, String message) {
	super();
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
