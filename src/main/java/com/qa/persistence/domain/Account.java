package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	private String username;
	private String password;
	@OneToMany(mappedBy="username", cascade=CascadeType.ALL)
	private List<Ingredient> shoppingList;
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<Ingredient> getShoppingList() {
		return shoppingList;
	}
	
}
