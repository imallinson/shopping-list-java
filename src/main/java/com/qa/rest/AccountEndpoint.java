package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	@Inject
	private AccountService service;
	
	@Path("/check")
	@PUT
	public String checkAccount(String accountJSON) {
		return service.checkAccount(accountJSON);
	}
	
	@Path("/create")
	@POST
	public String createAccount(String accountJSON) {
		return service.createAccount(accountJSON);
	}
	
	@Path("/clear/{username}")
	@PUT
	public String clearList(@PathParam("username") String username) {
		return service.clearList(username);
	}
	
}
