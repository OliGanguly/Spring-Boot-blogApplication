package com.example.BlogApplication.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogApplication.entities.Category;
import com.example.BlogApplication.entities.Post;
import com.example.BlogApplication.entities.User;
import com.example.BlogApplication.exceptions.ResourceNotFound;
import com.example.BlogApplication.payloads.PostDto;
import com.example.BlogApplication.repo.CategoryRepo;
import com.example.BlogApplication.repo.PostRepo;
import com.example.BlogApplication.repo.UserRepo;
import com.example.BlogApplication.service.PostService;

@Service
public class PoserServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelmapper;
	@Autowired
	private UserRepo userRepo;//to get user
	@Autowired
	private CategoryRepo catRepo;//to get category
	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer catId) {
		// Find User and category
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFound("User", "UserId", userId));
		Category cat = this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFound("Category", "Cat_Id", catId));
		
		Post post = this.modelmapper.map(postDto, Post.class);
		//we only took title and content from dto , other properties we are setting of Post class
		
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(cat);
		Post savedPost = this.postRepo.save(post);
		return this.modelmapper.map(savedPost, PostDto.class);
	}

	@Override
	public PostDto updatepOst(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		List<Post> list= this.postRepo.findAll();
		List<PostDto> dtoList = list.stream().map((p)->this.modelmapper.map(p, PostDto.class)).collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public PostDto getSinglePost(Integer postId) {
		// TODO Auto-generated method stub
		Post p = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post", "postID", postId));
		return this.modelmapper.map(p, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPostCategory(Integer categoryId) {
		
		// TODO Auto-generated method stub
		//fetch cat object
		 Category cat = this.catRepo.findById(categoryId).orElseThrow(()->new ResourceNotFound("Category", "Id", categoryId));
//		 List<Post> post = this.postRepo.findByCategory(categoryId);
		 List<Post> Resultpost= this.postRepo.findByCategory(cat);
		 List<PostDto> dtoList = Resultpost.stream().map((post)->this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public List<PostDto> getAllPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		User u = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFound("User", "user_id", userId));
		List<Post> listPost = postRepo.findByUser(u);
		List<PostDto> listPostDto= listPost.stream().map((post)->this.modelmapper.map(post,PostDto.class)).collect(Collectors.toList());
		return listPostDto;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
