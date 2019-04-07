package com.book.mytime.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mytime.domain.Admin;
import com.book.mytime.domain.User;
import com.book.mytime.exception.IdAlreadyExists;
import com.book.mytime.exception.RecordNotFoundException;
import com.book.mytime.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user){
		if(userRepository.existsById(user.getUserEmail()))
			throw new IdAlreadyExists("Email Id: " + user.getUserEmail() + " already exists");
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		List<User> userList = userRepository.findAll();
		if(userList.isEmpty())
			throw new RecordNotFoundException("No User Records Found");
		return userList;
	}


	public User getUserById(String userEmail) {
		if(!userRepository.existsById(userEmail))
			throw new RecordNotFoundException("Email Id: "+ userEmail + " doesn't exist");
		return userRepository.findById(userEmail).get();
	}
	
	public void deleteUserById(String userEmail) {
		if(!userRepository.existsById(userEmail))
			throw new RecordNotFoundException("Email Id: "+ userEmail + " doesn't exist");
		userRepository.deleteById(userEmail);
	}

	public User updateUserById(String userEmail, User user) {
		if(!userRepository.existsById(userEmail))
			throw new RecordNotFoundException("Email Id: "+ userEmail + " doesn't exist");
		return userRepository.save(user);
	}

	public boolean validateUser(String userEmail, String password) {
		if(!userRepository.existsById(userEmail))
			throw new RecordNotFoundException("Email Id: "+ userEmail + " doesn't exist");
		User user = userRepository.findById(userEmail).get();
		if(user.getPassword() == password)
			return true; 
		return false;
	}	
	
}
