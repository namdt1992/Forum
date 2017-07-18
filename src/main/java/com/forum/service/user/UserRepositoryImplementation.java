/**
 * 
 */
package com.forum.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.domain.User;
import com.forum.repository.UserRepository;
import com.forum.service.HandleException;
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
return user != null ? new RepositoryStatus<Long>(HttpStatus.OK, user.getId()) : new RepositoryStatus<Long>(HttpStatus.INTERNAL_SERVER_ERROR);
	} catch (Exception exception) {
return new RepositoryStatus<Long>(handleException.toHttpStatus(exception));
	}
	}
	
	public RepositoryStatus<Boolean> delete (Long id) {
		try {
			userRepository.delete(id);
			return new RepositoryStatus<Boolean>(HttpStatus.OK, true);
		} catch (Exception exception) {
			return new RepositoryStatus<Boolean>(handleException.toHttpStatus(exception), false);
		}
	}
	
	public RepositoryStatus<List<User>> findAll() {
		try {
			List <User> allUsers = userRepository.findAll();
		return !allUsers.isEmpty() ? new RepositoryStatus<List<User>>(HttpStatus.OK, allUsers) : new RepositoryStatus<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception exception) {
			return new RepositoryStatus<List<User>> (handleException.toHttpStatus(exception));
		}
	}
	
	public RepositoryStatus<User> findOne (long id) {
		try {
			User user = userRepository.findOne(id);
			return user != null ? new RepositoryStatus<User>(HttpStatus.OK,		 user):  new RepositoryStatus<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception exception) {
			return new RepositoryStatus<User> (handleException.toHttpStatus(exception));
		}
		}
	
	/*
	public User findByUsername (String userName) {
		return userRepository.findAll(userName);
	}
	*/
	
	}