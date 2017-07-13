package com.forum.service;

import org.springframework.stereotype.Service;

import com.forum.configuration.constant.HttpConstant;
import com.forum.util.validation.ExceptionStatus;

@Service
public class HandleException {

	public ExceptionStatus check (Exception exception ) {
String exceptionName = exception.getClass().getName();
switch (exceptionName) {
case "DataAccessException":
	return new ExceptionStatus(HttpConstant.CODE_SERVER_ERROR, HttpConstant.MESSAGE_SERVER_ERROR);
case "ObjectNotFoundException":
	return new ExceptionStatus(HttpConstant.CODE_NOT_FOUND, HttpConstant.MESSAGE_NOT_FOUND);
}
return new ExceptionStatus("", "");
	}
}