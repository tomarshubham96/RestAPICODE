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
public class GlobalDB {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.IDENTITY) private int contactId;
	 */

	@Id
	@NotNull
	private String gdbPhoneNumber;

	@NotNull
	private String gdbName;

	private String gdbEmailId;

	@JsonProperty
	@Column(nullable = true)
	private boolean isRegistered;

	@JsonProperty
	@Column(nullable = true)
	private boolean isSpam;

	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany(mappedBy = "contacts") private Set<User> users;
	 */

	public GlobalDB() {
	}

	public GlobalDB(String gdbPhoneNumber, String gdbName, String gdbEmailId, boolean isRegistered,
			boolean isSpam) {

		super();
		this.gdbPhoneNumber = gdbPhoneNumber;
		this.gdbName = gdbName;
		this.gdbEmailId = gdbEmailId;
		this.isSpam = isSpam;
		this.isRegistered = isRegistered;
	}
}
