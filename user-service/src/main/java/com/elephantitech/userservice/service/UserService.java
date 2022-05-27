package com.elephantitech.userservice.service;

import com.elephantitech.userservice.controller.dto.UserDto;
import com.elephantitech.userservice.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUser();

    User save(UserDto userDto);

    String login(String email, String password);


}
