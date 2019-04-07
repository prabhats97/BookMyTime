package com.book.mytime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.mytime.domain.Admin;
import com.book.mytime.domain.User;
import com.book.mytime.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/* To add a new user */ 
	@PostMapping(value = "")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
	}

	/* To fetch all User details */

	@GetMapping(value = "")
	public ResponseEntity<List<User>> getAllUser()
	{
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);	
	}

	/* To fetch a User details by Id */

	@GetMapping(value = "/{userEmail}")
	public ResponseEntity<User> getUserById (@PathVariable String userEmail)
	{
		return new ResponseEntity<User>(userService.getUserById(userEmail),HttpStatus.OK);		
	}
	
	/* To update User details by Id */

	@PutMapping(value = "/{userEmail}")
	public ResponseEntity<User> updateUserById(@PathVariable String userEmail,@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.updateUserById(userEmail,user),HttpStatus.OK);
	}

	
	/* To delete a user record by Id */

	@DeleteMapping(value = "/{userEmail}" )
	public ResponseEntity<?> deleteUserById(@PathVariable String userEmail)
	{
		userService.deleteUserById(userEmail);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
/* To validate an admin for login */
	
	@PostMapping(value = "validateUser/{userEmail}")
	public ResponseEntity<?> validateUser(@PathVariable String userEmail,@RequestParam String password)
	{
		if(userService.validateUser(userEmail, password))
			return new ResponseEntity<>(HttpStatus.FOUND);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
