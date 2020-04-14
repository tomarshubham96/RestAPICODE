package com.industrybuying.test.restApicode.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.industrybuying.test.restApicode.Entity.Contact;
import com.industrybuying.test.restApicode.Entity.User;
import com.industrybuying.test.restApicode.Repos.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	 
	
	public List<User> getAllUsersService(){		
		List users = new ArrayList<>();
		
		userRepository.findAll().forEach(users::add);
		
		return users;
	}
	
	public User getUserService(String phonenumber) {
		
	    return userRepository.findById(phonenumber).get();
	}

	public void adduserService(User user) {
		userRepository.save(user);
	}

	public void updateUserService(String phonenumber, User user) {
		userRepository.save(user);
	}

	public void deleteUserService(String phonenumber) {
		userRepository.deleteById(phonenumber);
		
	}

}
