package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public interface AccountRepository {

	String checkAccount(Account account);

	String createAccount(Account account);

	String clearList(String username);

}
