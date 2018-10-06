package com.jwt.spring.example.service;

import com.jwt.spring.example.entity.Profile;

public interface UserService {

	public String registerUser(String mobile);
	
	public Profile validateUser(String mobile, String otp) throws Exception;

}
