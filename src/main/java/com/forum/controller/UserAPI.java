/**
 * 
 */
package com.forum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NamDT8
 *
 */

@RestController
@RequestMapping("/api/user")
public class UserAPI extends AbstractAPI {
	/*
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
*/
}