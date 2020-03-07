package com.instagram.application.model;

import javax.persistence.*;

import com.instagram.application.enums.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long postId;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;   

    @OneToMany(mappedBy = "imgPost", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<PostImage> postImage;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<PostImage> getPostImage() {
		return postImage;
	}

	public void setPostImage(Set<PostImage> postImage) {
		this.postImage = postImage;
	}

	public Set<PostComment> getPostComment() {
		return postComment;
	}

	public void setPostComment(Set<PostComment> postComment) {
		this.postComment = postComment;
	}
	@OneToMany(mappedBy = "ccPost", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<PostComment> postComment;
    
	
	@OneToMany(mappedBy = "likePost", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<PostLike> postLike;
    
	
	public Set<PostLike> getPostLike() {
		return postLike;
	}

	public void setPostLike(Set<PostLike> postLike) {
		this.postLike = postLike;
	}
	@Column(name = "postContent")
    private String postContent;
    @Column(name = "postDate")
    private Date  postDate;   
	
	

    public long getPostId() {
		return postId;
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
		return postDate;
	}

	public void setPostDate(Date  postDate) {
		this.postDate = postDate;
	}

	
	 public Post(long postId, String postContent, Date  PostDate, long postBy) {
	        this.postId = postId;
	        this.postContent = postContent;
	        this.postDate = PostDate;	        
	    }
	public Post() {
		super();
	}	
}
