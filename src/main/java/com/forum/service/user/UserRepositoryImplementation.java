/**
 * 
 */
package com.forum.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.configuration.constant.HttpConstant;
import com.forum.domain.User;
import com.forum.repository.AbstractRepository;
import com.forum.service.HandleException;
import com.forum.util.validation.ExceptionStatus;
import com.forum.util.validation.RepositoryStatus;

/**
 * @author NamDT8
 *
 */

@Service
@Transactional
public class UserRepositoryImplementation implements UserService {
	
@Autowired
private AbstractRepository <User> userRepository;
@Autowired
private HandleException handleException;

public RepositoryStatus<Long> save(User user) {
	try {
		user = userRepository.save(user);
return new RepositoryStatus<Long>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS, user.getId());
	} catch (Exception exception) {
ExceptionStatus exceptionStatus = handleException.check(exception);
return new RepositoryStatus<Long>(exceptionStatus.getCode(), exceptionStatus.getMessage());
	}
	}
	
	public RepositoryStatus<Boolean> delete (Long id) {
		try {
			userRepository.delete(id);
			return new RepositoryStatus<Boolean>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS, Boolean.TRUE);
		} catch (Exception exception) {
			ExceptionStatus exceptionStatus = handleException.check(exception);
			return new RepositoryStatus<Boolean>(exceptionStatus.getCode(), exceptionStatus.getMessage(), Boolean.FALSE);
		}
	}
	
	public RepositoryStatus<List<User>> findAll() {
		try {
		return new RepositoryStatus<List<User>>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS,  
				userRepository.findAll());
		} catch (Exception exception) {
			ExceptionStatus exceptionStatus = handleException.check(exception);
			return new RepositoryStatus<List<User>> (exceptionStatus.getCode(), exceptionStatus.getMessage());
		}
	}
	
	public RepositoryStatus<User> findOne (long id) {
		try {
			return new RepositoryStatus<User>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS,		 userRepository.findOne(id));
		} catch (Exception exception) {
			ExceptionStatus exceptionStatus = handleException.check(exception);
			return new RepositoryStatus<User> (exceptionStatus.getCode(), exceptionStatus.getMessage());
		}
		}
	
	/*
	public User findByUsername (String userName) {
		return userRepository.findAll(userName);
	}
	*/
	
	}