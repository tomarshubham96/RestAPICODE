package com.industrybuying.test.restApicode.Entity;

import javax.validation.constraints.NotNull;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Entity
public class Contact {

	@Id
	@NotNull
	private String contactNumber;

	@NotNull
	private String contactName;

	private String contactEmailId;

	@JsonIgnore
	@ManyToMany(mappedBy = "contacts")
	private Set<User> users;

	public Contact() {
	}

	public Contact(String contactNumber, String contactName, String contactEmailId) {

		super();
		this.contactNumber = contactNumber;
		this.contactName = contactName;
		this.contactEmailId = contactEmailId;
	}
}
