package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public interface AccountRepository {

	Account checkAccount(String username);

	String createAccount(Account account);

	String clearList(String username);

}
