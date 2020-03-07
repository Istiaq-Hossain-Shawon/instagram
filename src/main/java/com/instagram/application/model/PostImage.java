package com.instagram.application.model;

import javax.persistence.*;

import com.instagram.application.enums.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_postImage")
public class PostImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long imageId;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    private Post imgPost; 
    

	
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public Post getImgpost() {
		return imgPost;
	}
	public void setImgpost(Post imgpost) {
		this.imgPost = imgpost;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	@Column(name = "imagePath")
    private String imagePath;
	
	@Column(name = "entryDate")
    private Date entryDate;
	

 

	 public PostImage(String imagePath,Date entryDate,Post imgpost) {
	        
		 this.imgPost = imgpost;
	        this.imagePath = imagePath;
	        this.entryDate = entryDate;	      
	    }
	public PostImage() {
		super();
	}	
}
