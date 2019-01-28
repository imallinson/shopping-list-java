package com.qa.persistence.repository;

import com.qa.persistence.domain.Ingredient;

public interface IngredientRepository {

	String getIngredients();

	String addIngredient(Ingredient ingredient);

	String removeIngredient(Long ingredientID);

	String updateIngredient(Long ingredientID, Ingredient ingredient);

}
