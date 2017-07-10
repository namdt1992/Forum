/**
 * 
 */
package com.forum.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.domain.User;
import com.forum.repository.AbstractRepository;

/**
 * @author NamDT8
 *
 */

@Service
@Transactional
public class UserRepositoryImplementation implements UserService {
	
@Autowired
private AbstractRepository <User> userRepository;

public User save(User user) {
return 		userRepository.save(user);
	}
	
	public void delete (long id) {
		userRepository.delete(id);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findOne (long id) {
		return (User) userRepository.findOne(id);
	}
	/*
	public User findByUsername (String userName) {
		return userRepository.findAll(userName);
	}
	*/
	}
