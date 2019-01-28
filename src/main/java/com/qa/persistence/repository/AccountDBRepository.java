package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Ingredient;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Override
	public String checkAccount(Account account) {
		Account accountInDB = findAccount(account.getUsername());
		if (accountInDB != null) {
			if (account.getPassword().equals(accountInDB.getPassword())) {
				return "{\"message\": \"logged in\"}";
			}
			return "{\"message\": \"incorect password\"}";
		}
		return "{\"message\": \"account does not exist\"}";
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
	public String clearList(String username) {
		Account accountInDB = findAccount(username);
		accountInDB.getShoppingList().stream().forEach(i -> manager.remove(i));
		return "{\"message\": \"shopping list cleared\"}";
	}
	
	private Account findAccount(String username) {
		return manager.find(Account.class, username);
	}

}
