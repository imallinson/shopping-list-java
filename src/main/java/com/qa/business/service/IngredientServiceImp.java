package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Ingredient;
import com.qa.persistence.repository.IngredientRepository;
import com.qa.util.JSONUtil;

public class IngredientServiceImp implements IngredientService {
	@Inject
	JSONUtil util;
	
	@Inject
	IngredientRepository repo;

	@Override
	public String getIngredients() {
		return util.getJSONForObject(repo.getIngredients());
	}

	@Override
	public String addIngredient(String ingredientJSON) {
		Ingredient ingredient = util.getObjectForJSON(ingredientJSON, Ingredient.class);
		return repo.addIngredient(ingredient);
	}

	@Override
	public String removeIngredient(Long ingredientID) {
		return repo.removeIngredient(ingredientID);
	}

	@Override
	public String updateIngredient(Long ingredientID, String ingredientJSON) {
		Ingredient ingredient = util.getObjectForJSON(ingredientJSON, Ingredient.class);
		return repo.updateIngredient(ingredientID, ingredient);
	}

}
