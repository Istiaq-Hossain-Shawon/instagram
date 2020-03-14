package com.instagram.application.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.instagram.application.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.gson.Gson;
import com.instagram.application.dto.ImageDto;
import com.instagram.application.dto.PostCommentDto;
import com.instagram.application.dto.PostDto;
import com.instagram.application.dto.PostLikeDto;
import com.instagram.application.model.Post;
import com.instagram.application.model.PostComment;
import com.instagram.application.model.PostLike;
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
	@GetMapping("/post/edit")
	public String editPost(Model model, @RequestParam("id") long id) {
		var data =postService.getPostById(id);	
		model.addAttribute("post", data);	
		return "post/edit";
	}
	
//	@PostMapping("/post/addComment")	
//	public String addComment(@ModelAttribute(name = "PostCommentDto") PostCommentDto postCommentDto, Model model) {
//		
//		
//		String username="";
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if (principal instanceof UserDetails) {
//			  username = ((UserDetails)principal).getUsername();
//			} else {
//			  username = principal.toString();
//		}		
//		User data=userService.getUserByUserName(username).get();
//		postCommentDto.setUserId(data.getId());
//		PostComment postcomment =postService.insertComment(postCommentDto);
//		BeanUtils.copyProperties(postcomment, postCommentDto);
//		//return new Gson().toJson(postCommentDto);
//		
//		model.addAttribute("message", "post added successfully");
//		return "redirect:/?_search=&_pageIndex=0&_rows=5&_sort=NA";
//	}	
	

	@PostMapping("/post/addComment")
	public String addComment(@ModelAttribute(name = "PostCommentDto") PostCommentDto postCommentDto, Model model) {
		
		
		var username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		
		var data=userService.getUserByUserName(username).get();
		postCommentDto.setUserId(data.getId());
		
		postService.insertComment(postCommentDto);
		model.addAttribute("message", "post added successfully");
		return "redirect:/?_search=&_pageIndex=0&_rows=5&_sort=NA";
	}	
	
	
	
	@PostMapping("/post/addLike")
	@ResponseBody
	public String addLike(@ModelAttribute(name = "PostLikeDto") PostLikeDto postLikeDto, Model model) {
		
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
		}	
		
		User data=userService.getUserByUserName(username).get();
		postLikeDto.setLikeBy(data.getId());
		PostLike postLike =postService.insertLike(postLikeDto);		
		BeanUtils.copyProperties(postLike, postLikeDto);				
		return new Gson().toJson(postLikeDto);
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
	

	@PostMapping("/post/search")
	public String search(@ModelAttribute(name = "PostDto") PostDto postDto, Model model) {		
				
		return "redirect:/?_search="+postDto.getPostContent()+"&_pageIndex=0&_rows=5&_sort=NA";
	}	
	@GetMapping("/post/deleteImage")
	public String deletePostImageByImageId(Model model, @RequestParam("postId") long postId, @RequestParam("imageId") long imageId) {
		postService.deleteByImageId(imageId);
		model.addAttribute("message", "image deleted successfully");
		return "redirect:/post/edit?id="+postId;
	}
	@PostMapping("/post/update")
	public String updatePost(@ModelAttribute(name = "post") PostDto post, Model model) {
		
		if (post.getPostContent() == null || post.getPostContent().trim().isEmpty()) {
			throw new RuntimeException("Please give post content");
		}
		if (post.getPostContent() == null || post.getPostContent().trim().isEmpty()) {
			throw new RuntimeException("Please give team  type");
		}	
		
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
		postService.update(post);
		model.addAttribute("message", "post added successfully");
		return "redirect:/post/edit?id="+post.getPostId();
	}	
	
}
