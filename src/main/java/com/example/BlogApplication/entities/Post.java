package com.example.BlogApplication.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * has two foreign key like user_id and category_id
 * 
 * */
@Getter
@Setter
@Entity
@Table(name = "Post")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int post_id;
 
 private String post_title;
 
 private String post_content;
 
 private String imageName;
 
 private Date addedDate;
 
 @ManyToOne
 private User user;
 
 @ManyToOne()
 @JoinColumn(name = "Cat_Id")
 private Category category;
 
}
