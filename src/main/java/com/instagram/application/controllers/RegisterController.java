package com.instagram.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.instagram.application.dto.UserDto;
import com.instagram.application.model.User;

@Controller
public class RegisterController {


	@GetMapping("/register/index")
	public String getAddCaptainPage(Model model) {
		model.addAttribute("pageTitle", "register");
		model.addAttribute("userDto", new UserDto());
		model.addAttribute("message", "Register new user");
		return "register/index";
	}	
}
