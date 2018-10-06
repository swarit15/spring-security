package com.jwt.spring.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.requestMatchers().and().authorizeRequests().antMatchers("/registration/validate*").authenticated();
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/console/**").permitAll().antMatchers("/oauth/**").permitAll();
		httpSecurity.headers().frameOptions().disable();
	}
}
