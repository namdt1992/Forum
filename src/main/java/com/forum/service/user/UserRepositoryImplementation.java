/**
 * 
 */
package com.forum.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.configuration.constant.HttpConstant;
import com.forum.domain.User;
import com.forum.repository.UserRepository;
import com.forum.service.HandleException;
import com.forum.util.validation.ExceptionStatus;
import com.forum.util.validation.RepositoryStatus;

/**
 * @author NamDT8
 *
 */

@Repository
@Transactional
public class UserRepositoryImplementation implements UserService {
	
@Autowired
private UserRepository userRepository;

@Autowired
private HandleException handleException;

public RepositoryStatus<Long> save(User user) {
	try {
		user = userRepository.save(user);
	if (user != null) {
return new RepositoryStatus<Long>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS, user.getId());
	} else {
		return new RepositoryStatus<Long>(HttpConstant.CODE_SERVER_ERROR, HttpConstant.MESSAGE_SERVER_ERROR);
	}
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
			List <User> allUsers = userRepository.findAll();
			if (!allUsers.isEmpty()) {
		return new RepositoryStatus<List<User>>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS, allUsers);
			} else {
				return new RepositoryStatus<List<User>>(HttpConstant.CODE_SERVER_ERROR, HttpConstant.MESSAGE_SERVER_ERROR);
			}
		} catch (Exception exception) {
			ExceptionStatus exceptionStatus = handleException.check(exception);
			return new RepositoryStatus<List<User>> (exceptionStatus.getCode(), exceptionStatus.getMessage());
		}
	}
	
	public RepositoryStatus<User> findOne (long id) {
		try {
			User user = userRepository.findOne(id);
			if (user != null) {
			return new RepositoryStatus<User>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS,		 user);
			} else {
				return new RepositoryStatus<User>(HttpConstant.CODE_SERVER_ERROR, HttpConstant.MESSAGE_SERVER_ERROR);
			}
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