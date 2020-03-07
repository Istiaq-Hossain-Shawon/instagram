package com.instagram.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instagram.application.model.Post;
import com.instagram.application.model.PostImage;

@Repository
@Transactional
public interface PostImageRepository extends JpaRepository<PostImage, Long>{
	
	Optional<PostImage> findByImageId(long imageId);	
	//List<PostImage> findByImgPost(Post imgPost);		
	
}
