package com.instagram.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instagram.application.model.Post;
import com.instagram.application.model.User;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long>{
	
	Optional<Post> findByPostId(long postId);
	
	//List<Post> findByUser(User user);
	
	//List<Team> findByCountry_CountryId(long id);
	
	Page<Post> findByPostContentContaining(String postContent,Pageable pageable);	
	
}
