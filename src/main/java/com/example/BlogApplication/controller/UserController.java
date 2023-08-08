package com.example.BlogApplication.controller;


import java.util.List;import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogApplication.payloads.UserDto;
import com.example.BlogApplication.repo.ApiResponse;
import com.example.BlogApplication.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
    
	@PostMapping("/add")
    public ResponseEntity<UserDto> creteUser(@Valid @RequestBody UserDto userdto){
		UserDto createUserDto = this.userService.createUser(userdto);
        return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
    }
	
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer userId){
		UserDto updatedUser = this.userService.update(userDto, userId);
		return  ResponseEntity.ok(updatedUser);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("USER DELETED SUCCESSFULLY",true),HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUser() {
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	//Exception handling - Resourse Not Found
	@GetMapping("/all/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}

}
