package com.industrybuying.test.restApicode.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.industrybuying.test.restApicode.Entity.User;

public interface UserRepository extends JpaRepository<User,String> {

}
