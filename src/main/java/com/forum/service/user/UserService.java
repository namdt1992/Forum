package com.forum.service.user;

import java.util.List;

import com.forum.domain.User;


public interface UserService {
	public User save(User user);
	public void delete(long id);
	public List<User> findAll();
	public User findOne (long id);
}