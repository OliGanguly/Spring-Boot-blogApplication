package com.example.BlogApplication.service;

import java.util.List;

import com.example.BlogApplication.entities.Category;
import com.example.BlogApplication.entities.Post;
import com.example.BlogApplication.payloads.PostDto;

public interface PostService {
//create
	PostDto createPost (PostDto postDto,Integer postId,Integer catId);
	PostDto updatepOst(PostDto postDto,Integer postId);
	void deletePost(Integer postId);
	List<PostDto> getAllPost();
	PostDto getSinglePost(Integer postId);
	
	List<PostDto> getAllPostCategory(Integer categoryId);
	List<PostDto> getAllPostByUser(Integer userId);
	
	
	List<PostDto> searchPost(String keyword);
}
