package com.industrybuying.test.restApicode.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.industrybuying.test.restApicode.Entity.Contact;
import com.industrybuying.test.restApicode.Entity.User;
import com.industrybuying.test.restApicode.Repos.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	 
	
	public List<Contact> getAllContactsService(String phoneNumber){		
		List contacts = new ArrayList<>();
		
		contactRepository.findByUsersPhoneNumber(phoneNumber).forEach(contacts::add);
		
		return contacts;
	}
	
	public Contact getContactService(String contactNumber) {
		
	    return contactRepository.findById(contactNumber).get();
	}

	public void addContactService(Contact contact) {
		contactRepository.save(contact);
	}

	public void updateContactService(Contact contact) {
		contactRepository.save(contact);
	}

	public void deleteContactService(String contactNumber) {
		contactRepository.deleteById(contactNumber);
		
	}
}
