package com.industrybuying.test.restApicode.Controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.industrybuying.test.restApicode.Entity.GlobalDB;
import com.industrybuying.test.restApicode.Entity.User;
import com.industrybuying.test.restApicode.Service.GlobalDBService;
import com.industrybuying.test.restApicode.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GlobalDBService globaldbService;

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsersService();
	}
	
	@RequestMapping("/users/{phonenumber}")
	public User getUser(@PathVariable("phonenumber") String phonenumber) {
		return userService.getUserService(phonenumber);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user) {
		globaldbService.addGlobalDBEntryService(new GlobalDB(user.getPhoneNumber(),user.getName(),user.getEmailId(),true,false));
		userService.adduserService(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{phonenumber}")
	public void updateUser(@PathVariable("phonenumber") String phonenumber, @RequestBody User user) {
		userService.updateUserService(phonenumber,user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{phonenumber}")
	public void deleteUser(@PathVariable String phonenumber) {
		userService.deleteUserService(phonenumber);
	}
	
}
