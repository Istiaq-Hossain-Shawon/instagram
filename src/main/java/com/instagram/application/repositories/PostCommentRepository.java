package com.instagram.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instagram.application.model.Post;
import com.instagram.application.model.PostComment;
import com.instagram.application.model.PostImage;

@Repository
@Transactional
public interface PostCommentRepository extends JpaRepository<PostComment, Long>{
	
		
	//List<PostImage> findByImgPost(Post imgPost);		
	
}
