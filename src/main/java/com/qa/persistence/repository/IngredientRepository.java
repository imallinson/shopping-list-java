package com.qa.persistence.repository;

import java.util.List;

import com.qa.persistence.domain.Ingredient;

public interface IngredientRepository {

	List<Ingredient> getIngredients(String username);

	String addIngredient(Ingredient ingredient);

	String removeIngredient(Long ingredientID);

	String updateIngredient(Long ingredientID, Ingredient ingredient);

}
