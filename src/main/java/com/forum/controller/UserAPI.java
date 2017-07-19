/**
 * 
 */
package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forum.domain.User;
import com.forum.service.user.UserService;
import com.forum.util.Jackson;
import com.forum.util.validation.RepositoryStatus;
import com.forum.util.view.Public;

/**
 * @author NamDT8
 *
 */

@RestController
@RequestMapping("/api/user")
public class UserAPI {
	
@Autowired
private UserService userRepository;

@GetMapping(value = "/all",
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<String> findAll() {

	RepositoryStatus<List<User>> status = userRepository.findAll();
return status.isSuccess() ?
		new ResponseEntity<String>(Jackson.java2Json(status, Public.class), status.getHttpStatus())
		: new ResponseEntity<String>(Jackson.java2Json(status), status.getHttpStatus());
}

}