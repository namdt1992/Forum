/**
 * 
 */
package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forum.configuration.constant.HttpConstant;
import com.forum.domain.User;
import com.forum.service.user.UserService;
import com.forum.util.Jackson;
import com.forum.util.validation.QueryStatus;
import com.forum.util.validation.RepositoryStatus;
import com.forum.util.validation.Status;
import com.forum.util.view.Public;

/**
 * @author NamDT8
 *
 */

@RestController
@RequestMapping("/api/user")
public class UserAPI extends AbstractAPI {
@Autowired
private UserService userRepository;

@GetMapping(value = "/_findOne		/all",
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<String> findAll() {

	RepositoryStatus<List<User>> status = userRepository.findAll();
if(!status.getCode().equals(HttpConstant.CODE_SUCCESS)) {
return new ResponseEntity<String>(Jackson.java2Json(new Status(status.getCode(),
        status.getMessage())), HttpStatus.NOT_FOUND);
}

return new ResponseEntity<String>
(Jackson.java2Json
		(new QueryStatus<User>
		(HttpConstant.CODE_SUCCESS,
        "found",
        status.getObject()),
		Public.class), HttpStatus.OK);
}

}