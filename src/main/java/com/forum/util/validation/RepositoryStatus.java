package com.forum.util.validation;

import org.springframework.http.HttpStatus;

public class RepositoryStatus <T extends Object> extends Status {

    private T t;

    public RepositoryStatus() {
	}

	public RepositoryStatus(String code, String message) {
        super(code, message);
    }

    public RepositoryStatus(String code, String message, T object) {
        super(code, message);
        this.t = object;
    }
    
    public RepositoryStatus(HttpStatus status) {
    	super(status);
    }
    
    public RepositoryStatus(HttpStatus httpStatus, T object) {
    	super(httpStatus);
    	this.t = object;
    }
    
    public RepositoryStatus(HttpStatus httpStatus, String message, T object) {
    	super(httpStatus, message);
    	this.t = object;
    }
    
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
