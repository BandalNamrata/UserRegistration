package com.elephantitech.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elephantitech.userservice.entity.User;

@Repository

public interface UserRepo extends JpaRepository<User, Long>{
	User findUserByEmailAndPassword(String email, String password);

}
