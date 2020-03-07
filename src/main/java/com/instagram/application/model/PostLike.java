package com.instagram.application.model;

import javax.persistence.*;

import com.instagram.application.enums.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_postLike")
public class PostLike implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long likeId;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    private Post likePost;   

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "likeBy", nullable = false)
    private User usrLike;    
	

	public User getUsrLike() {
		return usrLike;
	}
	public void setUsrLike(User usrLike) {
		this.usrLike = usrLike;
	}
	public long getLikeId() {
		return likeId;
	}
	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}
	public Post getLikePost() {
		return likePost;
	}
	public void setLikePost(Post likePost) {
		this.likePost = likePost;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}	
	@Column(name = "entryDate")
    private Date entryDate;
	

 

	 public PostLike(long likeId,long postId, String imagePath,Date entryDate) {
	        
	        this.likeId = likeId;
	        
	        this.entryDate = entryDate;	      
	    }
	public PostLike() {
		super();
	}	
}
