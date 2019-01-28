package com.qa.business.service;

public interface IngredientService {

	String getIngredient(Long ingredientID);

	String addIngredient(String ingredientJSON);

	String removeIngredient(Long ingredientID);

	String updateIngredient(Long ingredientID, String ingredientJSON);

}
