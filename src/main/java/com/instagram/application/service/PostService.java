package com.instagram.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.instagram.application.dto.PostCommentDto;
import com.instagram.application.dto.PostDto;
import com.instagram.application.dto.PostLikeDto;
import com.instagram.application.exceptions.ResourceAlreadyExistsException;
import com.instagram.application.model.Post;
import com.instagram.application.model.PostComment;
import com.instagram.application.model.PostImage;
import com.instagram.application.model.PostLike;
import com.instagram.application.repositories.PostCommentRepository;
import com.instagram.application.repositories.PostImageRepository;
import com.instagram.application.repositories.PostLikeRepository;
import com.instagram.application.repositories.PostRepository;
import com.instagram.application.repositories.UserRepository;
import com.instagram.application.util.Constants;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {

	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostImageRepository postImageRepository;
	
	@Autowired
	private PostCommentRepository postCommentRepository;
	
	@Autowired
	private PostLikeRepository postLikeRepository;

	public void insert(PostDto postdto) {
		Post post = new Post();
		post.setUser(postdto.getUser());
		post.setPostContent(postdto.getPostContent());
		post.setPostDate(new Date());
		
		postRepository.save(post);
		for (var temp : postdto.getImageDto()) {				
			postImageRepository.save(new PostImage(temp.getImageName(), new Date(), post));
		}

	}
	public void update(PostDto postdto) {
		Post post =postRepository.findById(postdto.getPostId()).get();		
		post.setPostContent(postdto.getPostContent());		
		postRepository.save(post);
		for (var temp : postdto.getImageDto()) {				
			postImageRepository.save(new PostImage(temp.getImageName(), new Date(), post));
		}

	}
	public PostComment insertComment(PostCommentDto postCmnDto) {
		var post=postRepository.findById(postCmnDto.getPostId()).get();
		var user=userRepository.findById(postCmnDto.getUserId()).get();
		PostComment postcomnt=new PostComment();
		postcomnt.setCcPost(post);
		postcomnt.setEntryDate(new Date());
		postcomnt.setCcUser(user);
		postcomnt.setCommentContent(postCmnDto.getCommentContent());
		postCommentRepository.save(postcomnt);
		return postcomnt; 

	}
	public PostLike insertLike(PostLikeDto postLikeDto) {
		var postLikeData=postLikeRepository.GetDataByPostIdAndUserId(postLikeDto.getPostId(),postLikeDto.getLikeBy());
		if(postLikeData.isEmpty()) {
			var post=postRepository.findById(postLikeDto.getPostId()).get();
			var user=userRepository.findById(postLikeDto.getLikeBy()).get();
			PostLike postLike=new PostLike();
			postLike.setLikePost(post);
			postLike.setEntryDate(new Date());
			postLike.setUsrLike(user);		
			postLikeRepository.save(postLike);
			return postLike;
		}
		return new PostLike();
		 
	}
	public void removeLike(PostLikeDto postLikeDto) {		
		var postLike=postLikeRepository.findById(postLikeDto.getLikeId()).get();			
		postLikeRepository.delete(postLike);		 
	}
	public void removeComment(PostCommentDto postCommentDto) {		
		var postComment=postCommentRepository.findById(postCommentDto.getCommentId()).get();			
		postCommentRepository.delete(postComment);		 
	}
	
	public Page<Post> getAll(String searchText,int pageIndex,int rows,String sort) {
		Pageable pageWithElements;
		if(sort.equals("PDA")) {			
			pageWithElements = PageRequest.of(pageIndex, rows,Sort.by("postDate").descending());
		}else {			
			pageWithElements = PageRequest.of(pageIndex, rows,Sort.by("postDate").descending());	
		}		
		Page<Post> teams=postRepository.fullTextSearch(searchText,pageWithElements);		
		return teams;
	}
	public Post getPostById(long id) {				
		Optional<Post> post=postRepository.findById(id);		
		return post.get();
	}
	public void deleteByImageId(long imageId) {	
		
		//team.getMembers().removeIf(p->p.getUserId()==playerId);
		PostImage postImage=postImageRepository.findByImageId(imageId).get();
		postImageRepository.delete(postImage);		
	}

}
