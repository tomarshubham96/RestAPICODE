package com.industrybuying.test.restApicode.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.industrybuying.test.restApicode.Entity.Contact;
import com.industrybuying.test.restApicode.Entity.GlobalDB;

public interface GlobalDBRepository extends JpaRepository<GlobalDB, String> {

	public List<GlobalDB> findByGdbNameStartingWithIgnoreCase(String gdbName);
	public List<GlobalDB> findByGdbNameContainingIgnoreCase(String gdbName);
}
