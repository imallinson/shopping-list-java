package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED; 
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Ingredient;

@Transactional(SUPPORTS)
@Default
public class IngredientDBRepository implements IngredientRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Override
	public List<Ingredient> getIngredients(String username) {
		Query query = manager.createQuery("SELECT i FROM Ingredient i");
		List<Ingredient> allIngredients = query.getResultList();
		List<Ingredient> usersIngredients = allIngredients.stream().filter(i -> i.getUsername().equals(username)).collect(Collectors.toList());
		return usersIngredients;
	}

	@Override
	@Transactional(REQUIRED)
	public String addIngredient(Ingredient ingredient) {
		manager.persist(ingredient);
		return "{\"message\": \"ingredient added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String removeIngredient(Long ingredientID) {
		Ingredient ingredientInDB = findIngredient(ingredientID);
		manager.remove(ingredientInDB);
		return "{\"message\": \"ingredient deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateIngredient(Long ingredientID, Ingredient ingredient) {
		Ingredient ingredientInDB = findIngredient(ingredientID);
		manager.remove(ingredientInDB);
		manager.persist(ingredient);
		return "{\"message\": \"ingredient updated\"}";
	}
	
	public Ingredient findIngredient(Long ingredientID) {
		return manager.find(Ingredient.class, ingredientID);
	}

}
