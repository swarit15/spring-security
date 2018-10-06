package com.jwt.spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.spring.example.entity.Profile;
import com.jwt.spring.example.service.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String registration(@RequestParam("mobile")String mobile) {
		return userService.registerUser(mobile);
	}
	
	@RequestMapping(value="/validate", method=RequestMethod.GET)
	public Profile validate(@RequestParam("mobile")String mobile, @RequestParam("otp")String otp) throws Exception {
		return userService.validateUser(mobile, otp);
	}
}
