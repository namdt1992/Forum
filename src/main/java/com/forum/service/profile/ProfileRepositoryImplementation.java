package com.forum.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.configuration.constant.HttpConstant;
import com.forum.domain.Profile;
import com.forum.repository.ProfileRepository;
import com.forum.service.HandleException;
import com.forum.util.validation.ExceptionStatus;
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
if (profile != null) {
return new RepositoryStatus<Profile>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS, profile);
	} else {
		return new RepositoryStatus<Profile>(HttpConstant.CODE_SERVER_ERROR, HttpConstant.MESSAGE_SERVER_ERROR);
	}
	} catch (Exception exception) {
ExceptionStatus exceptionStatus = handleException.check(exception);
return new RepositoryStatus<Profile>(exceptionStatus.getCode(), exceptionStatus.getMessage());
	}
}	

public RepositoryStatus<Boolean> delete (Long id) {
	try {
		profileRepository.delete(id);
		return new RepositoryStatus<Boolean>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS, Boolean.TRUE);
	} catch (Exception exception) {
		ExceptionStatus exceptionStatus = handleException.check(exception);
		return new RepositoryStatus<Boolean>(exceptionStatus.getCode(), exceptionStatus.getMessage(), Boolean.FALSE);
	}
}

public RepositoryStatus<Profile> findOne(long id) {
	try {
		Profile profile = profileRepository.findOne(id);
		if (profile != null) {
		return new RepositoryStatus<Profile>(HttpConstant.CODE_SUCCESS, HttpConstant.MESSAGE_SUCCESS, profile);
		} else {
			return new RepositoryStatus<Profile>(HttpConstant.CODE_SERVER_ERROR, HttpConstant.MESSAGE_SERVER_ERROR);
		}
	} catch (Exception exception) {
		ExceptionStatus exceptionStatus = handleException.check(exception);
		return new RepositoryStatus<Profile> (exceptionStatus.getCode(), exceptionStatus.getMessage());
	}
	}


}