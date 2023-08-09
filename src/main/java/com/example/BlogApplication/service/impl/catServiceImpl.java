package com.example.BlogApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogApplication.entities.Category;
import com.example.BlogApplication.entities.User;
import com.example.BlogApplication.exceptions.ResourceNotFound;
import com.example.BlogApplication.payloads.CategoriesDto;
import com.example.BlogApplication.repo.CategoryRepo;
import com.example.BlogApplication.service.CategoryService;

@Service
public class catServiceImpl implements CategoryService {
    @Autowired
	private ModelMapper modelMapper;
    @Autowired
    private CategoryRepo catRepo;
	@Override
	public CategoriesDto createCategory(CategoriesDto catDto) {
		// TODO Auto-generated method stub
		Category cat= this.catDtoToCat(catDto);
		Category savedCat = catRepo.save(cat);
		CategoriesDto savedCatDto = this.catToCatDto(savedCat);
		return savedCatDto;
	}

	@Override
	public CategoriesDto updateCategory(CategoriesDto catDto, Integer catId) {
		// TODO Auto-generated method stub
		Category cat = this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFound("Category", "Category Id", catId));
		cat.setCat_id(catDto.getCat_id());
		cat.setCat_tittle(catDto.getCat_tittle());
		cat.setCat_description(catDto.getCat_description());
		Category catSaved = this.catRepo.save(cat);
		return this.catToCatDto(catSaved);
	}

	@Override
	public void deleteCategory(Integer catId) {
		// TODO Auto-generated method stub
		Category cat = this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFound("Category", "Category Id", catId));
        this.catRepo.delete(cat);
	}

	@Override
	public CategoriesDto getById(Integer catId) {
		// TODO Auto-generated method stub
		Category cat = this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFound("Category", "Category Id", catId));
        return this.catToCatDto(cat);
	}

	@Override
	public List<CategoriesDto> getAllCat() {
		// TODO Auto-generated method stub
		List<Category> allCategories = this.catRepo.findAll();
		List<CategoriesDto> listDto= allCategories.stream().map(cat ->this.catToCatDto(cat)).collect(Collectors.toList());
		return listDto;
	}
	public CategoriesDto catToCatDto(Category cat) {
		CategoriesDto catDto = this.modelMapper.map(cat,CategoriesDto.class);
		return catDto;
	}
	public Category catDtoToCat(CategoriesDto catDto) {
		Category cat = this.modelMapper.map(catDto, Category.class);
		return cat;
	}

}
