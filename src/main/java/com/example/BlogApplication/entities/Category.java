package com.example.BlogApplication.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cat_id;
	@Column(name="title")
	private String cat_tittle;
	@Column(name = "description")
	private String cat_description;
	/*
	 * One cat has multiple post @OneToMany
	 * mapped by=GO TO POST.JAVA TAKE THE NAME category
	 * */
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Post> posts = new ArrayList<>();
	
	
	
	
	

}
