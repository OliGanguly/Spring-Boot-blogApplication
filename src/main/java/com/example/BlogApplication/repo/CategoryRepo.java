package com.example.BlogApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BlogApplication.entities.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
