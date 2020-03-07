package com.instagram.application.dto;



import java.io.Serializable;

import java.util.Date;
import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.instagram.application.model.User;


public class PostDto implements Serializable {
    
    private long postId;
	
    private User user;
    private String userEmail;
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	private String postContent;
    
    private Date  PostDate;
    
    private List<ImageDto> imageDto;
    
    public List<ImageDto> getImageDto() {
		return imageDto;
	}

	public void setImageDto(List<ImageDto> imageDto) {
		this.imageDto = imageDto;
	}
	private List<MultipartFile> images;
    
    public long getPostId() {
		return postId;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date  getPostDate() {
		return PostDate;
	}

	public void setPostDate(Date  postDate) {
		PostDate = postDate;
	}

	
	 public PostDto(long postId, String postContent, Date  PostDate, long postBy) {
	        this.postId = postId;
	        this.postContent = postContent;
	        this.PostDate = PostDate;	        
	    }
	public PostDto() {
		super();
	}	
}
