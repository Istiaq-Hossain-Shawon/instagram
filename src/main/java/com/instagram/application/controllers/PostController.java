package com.instagram.application.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.instagram.application.dto.ImageDto;
import com.instagram.application.dto.PostCommentDto;
import com.instagram.application.dto.PostDto;
import com.instagram.application.model.Post;
import com.instagram.application.model.PostComment;
import com.instagram.application.model.PostImage;
import com.instagram.application.repositories.PostRepository;
import com.instagram.application.service.PostService;
import com.instagram.application.service.UserService;
import com.instagram.application.util.Constants;


@Controller
public class PostController {

	
	@Autowired	ServletContext context;
	@Autowired	
	PostService postService;
	@Autowired	
	UserService userService;

	
	@GetMapping("/post/add")
	public String root(Model model) {
		model.addAttribute("post", new PostDto());		
		return "post/add";
	}
	
	@PostMapping("/post/addComment")
	@ResponseBody
	public PostCommentDto addComment(@ModelAttribute(name = "PostCommentDto") PostCommentDto postCommentDto, Model model) {
		
		
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		
		var data=userService.getUserByUserName(username).get();
		postCommentDto.setUserId(data.getId());
		var postcomment =postService.insertComment(postCommentDto);
		BeanUtils.copyProperties(postcomment, postCommentDto);
		return postCommentDto;
//		model.addAttribute("message", "post added successfully");
//		return "redirect:/?_search=&_pageIndex=0&_rows=5&_sort=NA";
	}	
	
	@PostMapping("/post/add")
	public String add(@ModelAttribute(name = "post") PostDto post, Model model) {
		
		if (post.getPostContent() == null || post.getPostContent().trim().isEmpty()) {
			throw new RuntimeException("Please give post content");
		}
		if (post.getPostContent() == null || post.getPostContent().trim().isEmpty()) {
			throw new RuntimeException("Please give team  type");
		}		
		if (null == post.getImages() || post.getImages().size() == 0) {
			throw new RuntimeException("Please give photo");
		}
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		
		var data=userService.getUserByUserName(username).get();
		post.setUser(data);
		
		try {
			List<ImageDto> images= new ArrayList<ImageDto>();
			for (var temp : post.getImages()) {
				ImageDto  imgDto= new ImageDto();
				byte[] bytes = temp.getBytes();
				String absoluteFilePath = context.getRealPath(Constants.UPLOADED_FOLDER);
				var fileName = System.currentTimeMillis() + temp.getOriginalFilename();
				Path path = Paths.get(absoluteFilePath + fileName);
				Files.write(path, bytes);
				imgDto.setImageName(fileName);
				imgDto.setImage(temp);	
				images.add(imgDto);
			}
			post.setImageDto(images);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}		
		postService.insert(post);
		model.addAttribute("message", "post added successfully");
		return "redirect:/?_search=&_pageIndex=0&_rows=5&_sort=NA";
	}	
}
