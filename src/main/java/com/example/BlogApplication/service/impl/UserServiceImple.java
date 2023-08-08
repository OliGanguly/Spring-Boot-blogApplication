package com.example.BlogApplication.service.impl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogApplication.entities.User;
import com.example.BlogApplication.exceptions.ResourceNotFound;
import com.example.BlogApplication.payloads.UserDto;
import com.example.BlogApplication.repo.UserRepo;
import com.example.BlogApplication.service.UserService;


@Service
public class UserServiceImple implements UserService {

	
	//I will perform database activity
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		//I need user Object
		//But I have userDto with me so I have to convert UserDto to user
		User user = this.DtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto update(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFound("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User updatedUser = this.userRepo.save(user);
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFound("User", "Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> list = this.userRepo.findAll();
		List <UserDto> userDtoList = list.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
		return userDtoList;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFound("User", "Id", userId));
		this.userRepo.delete(user);
	}
	//ModelMapper
	//convert UserDto to user
		private User DtoToUser(UserDto userdto) {
			User u=this.modelMapper.map(userdto,User.class);
//			                            source   destination
//			u.setId(userdto.getId());
//			u.setName(userdto.getName());
//			u.setEmail(userdto.getEmail());
//			u.setAbout(userdto.getAbout());
//			u.setPassword(userdto.getPassword());
			return u;
			
		}
	//conver User to UserDto
	private UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
//		userDto.setId(u.getId());
//		userDto.setName(u.getName());
//		userDto.setEmail(u.getEmail());
//		userDto.setAbout(u.getAbout());
//		userDto.setPassword(u.getPassword());
		return userDto;
		
	}
	

}
