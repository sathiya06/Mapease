package com.app.rab.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
	
	public String encodePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
	public boolean verifyPassword(String rawPassword, String encodedPassword) {
		return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
	}
	
}
