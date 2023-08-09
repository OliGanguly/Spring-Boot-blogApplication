package com.example.BlogApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogApplication.payloads.PostDto;
import com.example.BlogApplication.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
 
	@Autowired
	private PostService postService ;
	
	@PostMapping("/add/user/{userId}/category/{catId}")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto, 
			@PathVariable Integer userId , 
			@PathVariable Integer catId) {
		   PostDto createPostDto = this.postService.createPost(postDto, userId, catId);
		  return new ResponseEntity<PostDto>(createPostDto,HttpStatus.CREATED); 
		 
	}
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> fetchPostByUserId(@PathVariable Integer userId){
		List<PostDto> list = this.postService.getAllPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
		
	}
	@GetMapping("/category/{catId}/posts")
	public ResponseEntity<List<PostDto>> fetchPostByCatId(@PathVariable Integer catId){
		List<PostDto> list = this.postService.getAllPostCategory(catId);
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<PostDto>> fetchPostByCatId(){
		List<PostDto> list = this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(list,HttpStatus.OK);
		
	}
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId){
		PostDto post= this.postService.getSinglePost(postId);
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
		
	}
}
