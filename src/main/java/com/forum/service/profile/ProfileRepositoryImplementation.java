package com.forum.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.domain.Profile;
import com.forum.repository.ProfileRepository;
import com.forum.service.HandleException;
import com.forum.util.validation.RepositoryStatus;

@Repository
@Transactional
public class ProfileRepositoryImplementation implements ProfileService {
	
@Autowired
private ProfileRepository profileRepository;
@Autowired
private HandleException handleException;

public RepositoryStatus<Profile> save (Profile profile){
	try {
profile = profileRepository.save(profile);
return profile != null ? new RepositoryStatus<Profile>(HttpStatus.OK, profile) : new RepositoryStatus<Profile>(HttpStatus.INTERNAL_SERVER_ERROR);
	} catch (Exception exception) {
return new RepositoryStatus<Profile>(handleException.toHttpStatus(exception));
	}
}	

public RepositoryStatus<Boolean> delete (Long id) {
	try {
		profileRepository.delete(id);
		return new RepositoryStatus<Boolean>(HttpStatus.OK, true);
	} catch (Exception exception) {
		return new RepositoryStatus<Boolean>(handleException.toHttpStatus(exception), false);
	}
}

public RepositoryStatus<Profile> findOne(long id) {
	try {
		Profile profile = profileRepository.findOne(id);
		return profile != null ? new RepositoryStatus<Profile>(HttpStatus.OK, profile) : new RepositoryStatus<Profile>(HttpStatus.INTERNAL_SERVER_ERROR);
	} catch (Exception exception) {
			return new RepositoryStatus<Profile> (handleException.toHttpStatus(exception));
	}
	}


}