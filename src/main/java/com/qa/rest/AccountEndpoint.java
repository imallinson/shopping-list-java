package com.qa.rest;

import javax.inject.Inject; 
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	@Inject
	private AccountService service;
	
	@Path("/check/{username}")
	@GET
	public String checkAccount(@PathParam("username") String username) {
		return service.checkAccount(username);
	}
	
	@Path("/create")
	@POST
	public String createAccount(String accountJSON) {
		return service.createAccount(accountJSON);
	}
	
	@Path("/clear/{username}")
	@DELETE
	public String clearList(@PathParam("username") String username) {
		return service.clearList(username);
	}
}
