package com.instagram.application.dto;

import javax.persistence.*;

import com.instagram.application.enums.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


public class PostLikeDto implements Serializable {
    
    private long likeId;    
    
    private long postId; 

    
    public long getLikeId() {
		return likeId;
	}

	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getLikeBy() {
		return likeBy;
	}

	public void setLikeBy(long likeBy) {
		this.likeBy = likeBy;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	private long likeBy;    
	
	
	@Column(name = "entryDate")
    private Date entryDate;
	
	public PostLikeDto() {
		super();
	}	
}
