package com.elephantitech.userservice.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.elephantitech.userservice.controller.dto.UserDto;
import com.elephantitech.userservice.entity.Role;
import com.elephantitech.userservice.entity.User;
import com.elephantitech.userservice.repository.UserRepo;
@Service
@Slf4j
public class UserServiceImpl implements UserService{

	private final UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}


	@Override
	public List<User> getUser() {
		return userRepo.findAll();
	}

	@Transactional
	@Override
	public User save(UserDto userDto) {
		log.info("Saving the User {}", userDto.getName());
		User user = User.builder().
				mobileNumber(userDto.getMobileNumber()).
				adharCard(userDto.getAdharCard()).
				bloodGroup(userDto.getBloodGroup()).
				drivingLicence(userDto.getDrivingLicence()).
				email(userDto.getEmail()).
				name(userDto.getName()).
				password(userDto.getPassword()).
				phoneNo(userDto.getPhoneNo()).
				roles(List.of(new Role("ROLE_USER"))).
				build();
		return userRepo.save(user);
	}

	@Override
	public String login(String email, String password) {
		User user = userRepo.findUserByEmailAndPassword(email, password);
		if(user == null){
			throw new IllegalArgumentException("User email and password combination is wrong");
		}
		return "success";
	}


}
