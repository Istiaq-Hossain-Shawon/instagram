package com.instagram.application.repositories;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.instagram.application.model.Post;
@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long>{	
	
	Optional<Post> findByPostId(long postId);	
	
	@Query(value ="SELECT pst.* FROM tbl_post pst LEFT JOIN tbl_user usr ON pst.userId = usr.id where pst.postContent like %:text% or usr.Name like %:text% or usr.username like %:text%  or usr.email like %:text% "
			,nativeQuery = true)
	Page<Post> fullTextSearch(@Param("text") String text,Pageable pageable);	
	
}
