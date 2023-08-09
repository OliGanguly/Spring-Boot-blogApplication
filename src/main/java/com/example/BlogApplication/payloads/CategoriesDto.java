package com.example.BlogApplication.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoriesDto {
	private int cat_id;
	@NotEmpty
	@Size(min=4,max=100,message = "Length should be between 4-100")
	private String cat_tittle;
	@Size(min=10,max=100,message = "Length should be between 4-100")
	private String cat_description;
}
