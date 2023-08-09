package com.example.BlogApplication.controller;

import java.util.List;

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

import com.example.BlogApplication.entities.Category;
import com.example.BlogApplication.payloads.CategoriesDto;
import com.example.BlogApplication.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CatController {
	
	@Autowired
	private CategoryService catService;

	@PostMapping("/add")
	public ResponseEntity<CategoriesDto> createCat( @Valid @RequestBody CategoriesDto catDto ){
		System.out.printf("oliiiiiiiiiiiiiiiiiiii",catDto);
		CategoriesDto catDtoResult =  catService.createCategory(catDto);
		return new ResponseEntity<CategoriesDto>(catDtoResult,HttpStatus.CREATED);
	}

	
	@PutMapping("/update/{catId}")
	public ResponseEntity<CategoriesDto> updateCategory( @Valid @RequestBody CategoriesDto catDto,@PathVariable Integer catId){
	   CategoriesDto catDtoResult =  catService.updateCategory(catDto, catId);
		return new ResponseEntity<CategoriesDto>(catDtoResult,HttpStatus.OK);	
	}
	@DeleteMapping("/delete/{catId}")
	public void deleteCategory(@PathVariable Integer catId) {
		catService.deleteCategory(catId);
	}
	@GetMapping("/get/{catId}")
	public ResponseEntity<CategoriesDto> getSingleCat(@PathVariable Integer catId){
		CategoriesDto data = this.catService.getById(catId);
		return new ResponseEntity<CategoriesDto>(data,HttpStatus.OK);
	}
	@GetMapping("/get/all")
	public ResponseEntity<List<CategoriesDto>> getAllCat(){
		List<CategoriesDto> all =  this.catService.getAllCat();
		return new ResponseEntity<List<CategoriesDto>>(all,HttpStatus.OK);
	}
}
