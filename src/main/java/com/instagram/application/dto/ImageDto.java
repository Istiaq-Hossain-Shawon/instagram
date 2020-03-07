package com.instagram.application.dto;



import java.io.Serializable;

import java.util.Date;
import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.instagram.application.model.User;


public class ImageDto implements Serializable {
    
    	
    private String  imageName;
    private MultipartFile image;
    
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public ImageDto() {
		super();
	}	
}
