package com.example.BlogApplication.repo;

import com.example.BlogApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepo extends JpaRepository<User,Integer> {

}
