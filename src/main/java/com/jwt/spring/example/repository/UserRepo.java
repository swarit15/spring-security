package com.jwt.spring.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.spring.example.entity.Profile;

@Repository
public interface UserRepo extends JpaRepository<Profile, Long>{

	public Profile findByMobile(String mobile);
	
	public Profile findByMobileAndOtp(String mobile, String otp);
}
