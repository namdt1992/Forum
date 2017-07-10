/**
 * 
 */
package com.forum.controller;

import org.springframework.http.HttpStatus;

import com.forum.configuration.constant.HttpConstant;

/**
 * @author NamDT8
 *
 */
public class AbstractAPI {

	public AbstractAPI() {
		super();
	}

    protected HttpStatus getStatus(String code) {
    	
        if(code.equals(HttpConstant.CODE_SUCCESS)) {
            return HttpStatus.OK;
        }

        if(code.equals(HttpConstant.CODE_BAD_REQUEST)) {
            return HttpStatus.BAD_REQUEST;
        }

        if(code.equals(HttpConstant.CODE_NOT_FOUND)) {
            return HttpStatus.NOT_FOUND;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    
}