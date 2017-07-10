package com.forum.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.domain.Profile;
import com.forum.repository.AbstractRepository;

@Service
@Transactional
public class ProfileRepositoryImplementation implements ProfileService {
	
@Autowired
private AbstractRepository<Profile> profileRepository;

public Profile save (Profile profile){
return profileRepository .save(profile);
}

public void delete (long id) {
	profileRepository.delete(id);
}

public Profile findOne(long id) {
	return profileRepository.findOne(id);
}

}