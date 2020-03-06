package com.instagram.application.controllers;

import com.instagram.application.enums.Role;
import com.instagram.application.model.User;

import com.instagram.application.repositories.UserRepository;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {

	private final UserRepository userRepository;
	
	
	private final PasswordEncoder passwordEncoder;
	

	public RootController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		
	}

	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name="error", required = false) String error) {				
		generateUsers();		
		model.addAttribute("error", error);
		return "auth/login";
	}	
	private void generateUsers() {
		if (userRepository.findByUsername("user").isEmpty()) {
			var user = new User();
			user.setUsername("user");
			user.setEmail("hossain.ict@gmail.com");
			user.setPassword(passwordEncoder.encode("1"));				
			user.setRole(Role.ROLE_USER);			
			userRepository.save(user);
		}

	}
}
