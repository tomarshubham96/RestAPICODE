package com.industrybuying.test.restApicode.Entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data

@Entity
public class User {

	@Id
	@Column(nullable=false)
	private String phoneNumber;
	
	@NotNull
	private String name;
	
	
	private String emailId;	
		
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_contacts",
        joinColumns = @JoinColumn(name = "user_Phone", referencedColumnName = "phoneNumber"),
        inverseJoinColumns = @JoinColumn(name = "contact_Phone", referencedColumnName = "contactNumber"))
	private Set<Contact> contacts;
	

	public User() {
	}
	
	public User(String phoneNumber, String name, String emailId /*Contact... contacts*/) {
		
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.emailId = emailId;
	}	
	
}
