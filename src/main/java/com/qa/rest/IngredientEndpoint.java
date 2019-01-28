package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.IngredientService;

@Path("/ingredient")
public class IngredientEndpoint {
	@Inject
	private IngredientService service;
	
	@Path("/get/{username}")
	@GET
	public String getIngredients(@PathParam("username") String username) {
		return service.getIngredients(username);
	}
	
	@Path("/add")
	@POST
	public String addIngredient(String ingredientJSON) {
		return service.addIngredient(ingredientJSON);
	}
	
	@Path("/remove/{id}")
	@DELETE
	public String removeIngredient(@PathParam("id") Long ingredientID) {
		return service.removeIngredient(ingredientID);
	}
	
	@Path("/update/{id}")
	@GET
	public String updateIngredient(@PathParam("id") Long ingredientID, String ingredientJSON) {
		return service.updateIngredient(ingredientID, ingredientJSON);
	}
}
