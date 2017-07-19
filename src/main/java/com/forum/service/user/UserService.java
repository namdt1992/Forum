package com.forum.service.user;

import java.util.List;

import com.forum.domain.User;
import com.forum.util.validation.RepositoryStatus;


public interface UserService {
	public RepositoryStatus<Long> save(User user);
	public RepositoryStatus<Boolean> delete(Long id);
	public RepositoryStatus<List<User>> findAll();
	public RepositoryStatus<User> findOne (long id);
}