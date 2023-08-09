package com.example.BlogApplication.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @Column(name = "User_Name",nullable = false,length = 100)
    private String name;
    private String email;
    private String about;
    private String password;
	
    /*
     * One user can have many posts
     * 
     * */
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     private List<Post> posts = new ArrayList<>();


}
