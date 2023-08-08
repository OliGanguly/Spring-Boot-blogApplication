package com.example.BlogApplication.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*Directly expose data to api
* will not expose entity
* data transfer - userDao
* */
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
    private int id;
    @NotEmpty 
    //black+not null
    @Size(min = 4,message="UserName must be minimum of 4 characters")
    private String name;
    @Email(message = "Your Email address is not valid")
    private String email;
    @NotNull
    private String about;
    @NotNull
    @Size(min=3,max=10, message = "password must be in between 3-10 character")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$",message = "Min 1 uppercase letter.\r\n"
    		+ "Min 1 lowercase letter.\r\n"
    		+ "Min 1 special character.\r\n"
    		+ "Min 1 number.\r\n"
    		+ "Min 8 characters.")
    private String password;

}
