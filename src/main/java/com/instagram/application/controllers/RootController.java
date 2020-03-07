package com.instagram.application.controllers;

import com.instagram.application.dto.ImageDto;
import com.instagram.application.dto.PostCommentDto;
import com.instagram.application.dto.PostDto;
import com.instagram.application.enums.Role;
import com.instagram.application.model.Post;
import com.instagram.application.model.PostImage;
import com.instagram.application.model.User;

import com.instagram.application.repositories.UserRepository;
import com.instagram.application.service.PostService;
import com.instagram.application.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {

	private final UserRepository userRepository;
	@Autowired	
	PostService postService;
	@Autowired	
	UserService userService;
	
	private final PasswordEncoder passwordEncoder;
	

	public RootController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		
	}

	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("post", new PostDto());
		var data =postService.getAll("",0,5,"PDA");
		
		List<PostDto> postDtoList= new ArrayList<PostDto>();
		for (Post temp : data.getContent()) {				
			PostDto postDto= new PostDto();
			
		}
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("posts", data.getContent());
		model.addAttribute("totalPages",data.getTotalPages());
		model.addAttribute("pageIndex",0);
		model.addAttribute("PostCommentDto",new PostCommentDto());
		
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		model.addAttribute("loginUser",userService.getUserByUserName(username).get());	
		
		return "index";
	}	

	@RequestMapping(value = "/",params= {"_search","_pageIndex","_rows","_sort"},  method = RequestMethod.GET)
	public String getAll(Model model,
			@RequestParam(value = "_search") String searchText,
			@RequestParam(value = "_pageIndex") int pageIndex,
			@RequestParam(value = "_rows") int rows,
			@RequestParam(value = "_sort") String sort) {
		model.addAttribute("post", new PostDto());
		var data =postService.getAll(searchText,pageIndex,rows,sort);
		
		List<PostDto> postDtoList= new ArrayList<PostDto>();
		for (Post temp : data.getContent()) {				
			PostDto postDto= new PostDto();
			
		}
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("posts", data.getContent());
		model.addAttribute("totalPages",data.getTotalPages());
		model.addAttribute("pageIndex",pageIndex);
model.addAttribute("PostCommentDto",new PostCommentDto());
		
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		model.addAttribute("loginUser",userService.getUserByUserName(username).get());	
		
		return "index";
	}
	@GetMapping("/account/index")
	public String account(Model model) {
		model.addAttribute("post", new PostDto());
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		
		var data=userService.getUserByUserName(username).get();
		model.addAttribute("user", data);
		return "account/index";
	}
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name="error", required = false) String error) {				
		generateUsers();		
		model.addAttribute("error", error);
		model.addAttribute("message", "login...");
		return "auth/login";
	}	
	private void generateUsers() {
		if (userRepository.findByUsername("user").isEmpty()) {
			var user = new User();
			user.setUsername("user");
			user.setEmail("hossain.ict@gmail.com");
			user.setPassword(passwordEncoder.encode("1"));	
			user.setLogo("default.jpg");				
			user.setRole(Role.ROLE_USER);			
			userRepository.save(user);
		}

	}
}
