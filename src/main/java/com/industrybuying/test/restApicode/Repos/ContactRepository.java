package com.industrybuying.test.restApicode.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.industrybuying.test.restApicode.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {
	
	public List<Contact> findByUsersPhoneNumber(String phoneNumber);

}
