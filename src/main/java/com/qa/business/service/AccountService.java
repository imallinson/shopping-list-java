package com.qa.business.service;

public interface AccountService {

	String checkAccount(String username);

	String createAccount(String accountJSON);

	String clearList(String username);

}
