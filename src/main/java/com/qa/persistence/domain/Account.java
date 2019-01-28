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
	@OneToMany(mappedBy="username", cascade=CascadeType.PERSIST)
	private List<Ingredient> shoppingList;
}
