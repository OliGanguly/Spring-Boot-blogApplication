package com.example.BlogApplication.service;

import java.util.List;

import com.example.BlogApplication.payloads.CategoriesDto;



public interface CategoryService {
	//create
	public CategoriesDto createCategory(CategoriesDto catDto);
	//update
	public CategoriesDto updateCategory(CategoriesDto catDto, Integer catId);
	//delete
	public void deleteCategory(Integer catId);
	//getById
	public CategoriesDto getById(Integer catId );
	//getall
	public List<CategoriesDto> getAllCat();
	

}
