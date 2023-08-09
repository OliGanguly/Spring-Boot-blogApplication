package com.example.BlogApplication.payloads;

import java.util.Date;

import com.example.BlogApplication.entities.Category;
import com.example.BlogApplication.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

//	private int post_id;
	private String post_title;
	private String post_content;
	private String imageName;
	private Date addedDate;
	private UserDto user;
	private CategoriesDto category;
	
	
	
	
}
