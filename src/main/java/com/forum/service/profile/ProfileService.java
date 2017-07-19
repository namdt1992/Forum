package com.forum.service.profile;

import com.forum.domain.Profile;
import com.forum.util.validation.RepositoryStatus;

public interface ProfileService {
	
public RepositoryStatus<Profile> save(Profile profile);
public RepositoryStatus<Boolean> delete (Long id);
public RepositoryStatus<Profile> findOne(long id);

}