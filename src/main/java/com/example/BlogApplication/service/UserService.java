package com.example.BlogApplication.service;

import com.example.BlogApplication.payloads.UserDto;

import java.util.List;

import org.springframework.stereotype.Service;


public interface UserService {
    //When we tranfering data we use dto class
    public UserDto createUser(UserDto user);
    public UserDto update(UserDto user,Integer userId);
    public UserDto getUserById(Integer userId);
    public List<UserDto> getAllUser();
    void deleteUser(Integer userId);
}
