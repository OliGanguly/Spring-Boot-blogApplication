package com.example.BlogApplication.payloads;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoriesDto {
	private int cat_id;
	private String cat_tittle;
	private String cat_description;
}
