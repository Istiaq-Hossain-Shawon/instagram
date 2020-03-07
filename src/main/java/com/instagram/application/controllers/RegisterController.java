package com.instagram.application.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.instagram.application.dto.UserDto;
import com.instagram.application.enums.Role;
import com.instagram.application.model.User;
import com.instagram.application.service.UserService;
import com.instagram.application.util.Constants;

@Controller
public class RegisterController {

	@Autowired	ServletContext context;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register/index")
	public String getAddCaptainPage(Model model) {
		model.addAttribute("pageTitle", "register");
		model.addAttribute("userDto", new UserDto());
		model.addAttribute("message", "Register new user");
		return "register/index";
	}
	@PostMapping("/register/new")
	public String add(@ModelAttribute(name = "user") UserDto user,@RequestParam("file") MultipartFile file,Model model) {
		if(user.getName() == null || user.getName().trim().isEmpty()) {
			throw new RuntimeException("Please give  name");
		}
		if(user.getUsername() == null || user.getUsername().trim().isEmpty()) {
			throw new RuntimeException("Please give user name");
		}
		
		if(user.getConfirmPassword() == null || user.getConfirmPassword().trim().isEmpty()) {
			throw new RuntimeException("Please give confirm Password");
		}
		if(user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			throw new RuntimeException("Please give confirm Password");
		}
		if(!user.getConfirmPassword().equals(user.getPassword())) {
			throw new RuntimeException("Password does not match");
		}
		if(user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			throw new RuntimeException("Please give email");
		}
		if (file.isEmpty()) {
			 throw new RuntimeException("Please select a file to upload");
		}
		 try {
			 byte[] bytes = file.getBytes();
			 String absoluteFilePath = context.getRealPath(Constants.UPLOADED_FOLDER);
			 var fileName = System.currentTimeMillis() + file.getOriginalFilename();
			 Path path = Paths.get(absoluteFilePath + fileName);
	         Files.write(path, bytes);
	         user.setLogo(fileName);
	         user.setRole(Role.ROLE_USER);
	         userService.addUser(user);
	         model.addAttribute("message", "User register successfully");
	         return "auth/login";
	    }catch (IOException e) {
	        	throw new RuntimeException(e.getMessage());
	    }	
		
	}
}
