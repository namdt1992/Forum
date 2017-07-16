package com.forum.service;

import com.forum.configuration.constant.HttpConstant;

public class AbstractService {
public String findMessageByCode (String code) {
	switch (code) {
	case HttpConstant.CODE_SUCCESS:
		return HttpConstant.MESSAGE_SUCCESS;
	case HttpConstant.CODE_BAD_REQUEST:
		return HttpConstant.MESSAGE_BAD_REQUEST;
	case HttpConstant.CODE_NOT_FOUND:
		return HttpConstant.MESSAGE_NOT_FOUND;
	}
    return HttpConstant.MESSAGE_SERVER_ERROR;
	}
}
