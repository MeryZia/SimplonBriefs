package com.example.EmpMgtSpring.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword="springBoot";
		String encodedPassword=encoder.encode(rawPassword);
		System.out.println(encodedPassword);
	
	}
}
