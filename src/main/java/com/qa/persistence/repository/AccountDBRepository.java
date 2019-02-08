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
public class AccountDBRepository implements AccountRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Override
	public Account checkAccount(String username) {
		return findAccount(username);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(Account account) {
		Account accountInDB = findAccount(account.getUsername());
		if (accountInDB == null) {
			manager.persist(account);
			return "{\"message\": \"account sucessfully created\"}";
		}
		return "{\"message\": \"account with that username already exists\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String clearList(String username) {
		Query query = manager.createQuery("SELECT i FROM Ingredient i");
		List<Ingredient> allIngredients = query.getResultList();
		List<Ingredient> usersIngredients = allIngredients.stream().filter(i -> i.getUsername().equals(username)).collect(Collectors.toList());
		usersIngredients.stream().forEach(i -> manager.remove(i));
		return "{\"message\": \"shopping list cleared\"}";
	}
	
	private Account findAccount(String username) {
		return manager.find(Account.class, username);
	}

}
