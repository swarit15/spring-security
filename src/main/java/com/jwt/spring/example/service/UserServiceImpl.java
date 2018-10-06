package com.jwt.spring.example.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.spring.example.entity.Profile;
import com.jwt.spring.example.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String registerUser(String mobile) {
		Profile profile = userRepo.findByMobile(mobile);
		
		Random random = new Random();
		String otp = String.format("%04d", random.nextInt(10000));
		System.out.println("OTP :: "+otp);
		otp = passwordEncoder.encode(otp);
		if(profile == null) {
			profile = new Profile();
			profile.setMobile(mobile);
			profile.setOtp(otp);
			userRepo.save(profile);
		}else {
			profile.setOtp(otp);
			userRepo.save(profile);
		}
		
		return otp;
	}

	@Override
	public Profile validateUser(String mobile, String otp) throws Exception {
		Profile profile = userRepo.findByMobileAndOtp(mobile, otp);
		if(profile == null) {
			throw new Exception ("User not found");
		}
		
		return profile;
		
	}

}
