package com.instagram.application.model;

import javax.persistence.*;

import com.instagram.application.enums.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_postComment")
public class PostComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long commentId;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    private Post ccPost;   


    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User ccUser; 
    
    
    
	
	public User getCcUser() {
		return ccUser;
	}
	public void setCcUser(User ccUser) {
		this.ccUser = ccUser;
	}
	@Column(name = "commentContent")
    private String commentContent;
	
	@Column(name = "entryDate")
    private Date entryDate;
	



	 public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public Post getCcPost() {
		return ccPost;
	}
	public void setCcPost(Post ccPost) {
		this.ccPost = ccPost;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public PostComment(long commentId,long postId, String commentContent,Date entryDate) {
	        
	        this.commentId = commentId;
	        this.commentContent = commentContent;
	        this.entryDate = entryDate;	      
	    }
	public PostComment() {
		super();
	}	
}
