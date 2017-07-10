package com.forum.service.profile;

import com.forum.domain.Profile;

public interface ProfileService {
	
public Profile save(Profile profile);
public void delete (long id);
public Profile findOne(long id);

}