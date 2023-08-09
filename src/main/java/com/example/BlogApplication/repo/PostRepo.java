package com.example.BlogApplication.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogApplication.entities.Category;
import com.example.BlogApplication.entities.Post;
import com.example.BlogApplication.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
  
	//custome finder methods
	List<Post> findByUser( User user);
	List<Post> findByCategory(Category category);
	
}
