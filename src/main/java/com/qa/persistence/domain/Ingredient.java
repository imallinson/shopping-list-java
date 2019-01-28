package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ingredientID;
	private String ingredientName;
	private Double amount;
	private String measurement;
	private String username;
	
	public Long getIngredientID() {
		return ingredientID;
	}
	
	public String getIngredientName() {
		return ingredientName;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public String getMeasurement() {
		return measurement;
	}

	public String getUsername() {
		return username;
	}	
	
}
