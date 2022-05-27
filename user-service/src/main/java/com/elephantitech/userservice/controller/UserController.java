package com.elephantitech.userservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.elephantitech.userservice.controller.dto.UserDto;
import com.elephantitech.userservice.entity.EmailRequest;
import com.elephantitech.userservice.entity.User;
import com.elephantitech.userservice.service.EmailService;
import com.elephantitech.userservice.service.UserService;

@RestController
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmailService emailService;



    @GetMapping("/list")
    public List<UserDto> getUser() {
    	List<User> user=userService.getUser();
    	return  user
				.stream()
				.map(a -> modelMapper.map(a, UserDto.class))
				.collect(Collectors.toList());

    }

    @PostMapping("/registration")
    public String registerUserAccount(@RequestBody UserDto userDto) {
        log.info("In Registration API for saving user {}",userDto.getName());
        userService.save(userDto);
        log.info("Saved the User Info");
        return "success";

    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.login(email, password);
    }
    
    //api to send email
  /*  @PostMapping("/sendmail")
    public ResponseEntity<?> sendMail(@RequestBody EmailRequest request){
    	System.out.println(request);
    	this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
    	return ResponseEntity.ok("Done...");
    	
    }*/


}
