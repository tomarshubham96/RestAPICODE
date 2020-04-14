package com.industrybuying.test.restApicode.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.industrybuying.test.restApicode.Entity.Contact;
import com.industrybuying.test.restApicode.Entity.GlobalDB;
import com.industrybuying.test.restApicode.Entity.User;
import com.industrybuying.test.restApicode.Service.ContactService;
import com.industrybuying.test.restApicode.Service.GlobalDBService;
import com.industrybuying.test.restApicode.Service.UserService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GlobalDBService globaldbService;

	@RequestMapping("/users/{phoneNumber}/contacts")
	public List<Contact> getAllContacts(@PathVariable String phoneNumber) {
		return contactService.getAllContactsService(phoneNumber);
	}
	
	@RequestMapping("/users/{phoneNumber}/contacts/{contactNumber}")
	public Contact getContact(@PathVariable String contactNumber) {
		return contactService.getContactService(contactNumber);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users/{phoneNumber}/contacts")
	public void addContact(@RequestBody Contact contact, @PathVariable String phoneNumber) {
		
		boolean spamFlag=false;
		boolean registeredFlag=false;
		
		if(contact.getContactNumber().startsWith("6")) {			
			spamFlag = true;
		}
		if(userService.getAllUsersService().
				stream().filter(u->u.getPhoneNumber().equals(contact.getContactNumber())).findAny().orElse(null) != null){
			
			registeredFlag=true;
		}
		
		globaldbService.addGlobalDBEntryService(new GlobalDB(contact.getContactNumber(),contact.getContactName(),contact.getContactEmailId(),registeredFlag,spamFlag));
		contactService.addContactService(contact);	
		userService.getUserService(phoneNumber).getContacts().add(contact);
		userService.adduserService(userService.getUserService(phoneNumber));
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{phoneNumber}/contacts/{contactNumber}")
	public void updateUser(@PathVariable String phoneNumber,@PathVariable String contactNumber, @RequestBody Contact contact) {
		//contact.setUser(new User(phoneNumber,"",""));
		contactService.updateContactService(contact);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{phoneNumber}/contacts/{contactNumber}")
	public void deleteUser(@PathVariable String contactNumber) {
		contactService.deleteContactService(contactNumber);
	}
}
