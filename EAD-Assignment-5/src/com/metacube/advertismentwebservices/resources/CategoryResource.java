package com.metacube.advertismentwebservices.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.metacube.advertismentwebservices.model.Category;
import com.metacube.advertismentwebservices.Common.Status;
import com.metacube.advertismentwebservices.facade.CategoryFacade;

@Path("/CategoryResource")
public class CategoryResource {

	CategoryFacade categoryFacade = CategoryFacade.getInstance();

	/**
	 * Function to insert data in category table
	 * 
	 * @param authorizationString
	 * @param category
	 * @return status
	 */
	@POST
	@Path("/SetFeeds")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status insertIntoCategories(@HeaderParam("Authorization") String authorizationString, Category category) {

		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}
		Status status = categoryFacade.insertCategory(category.getName());
		return status;
	}

	/**
	 * Function to get all the categories
	 * 
	 * @param authorizationString
	 * @return data
	 */
	@GET
	@Path("/GetCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCategories(@HeaderParam("Authorization") String authorizationString) {

		if (!"GET-2018".equals(authorizationString)) {
			return "" + Status.ERROR;
		}

		List<Category> categoryList = categoryFacade.getAll();
		if (categoryList.size() != 0) {
			Gson gson = new Gson();
			System.out.println(gson.toJson(categoryList));
			String categoryJson = gson.toJson(categoryList);
			return categoryJson;
		}
		return "No Date Present";
	}

	/**
	 * Function to update the category by id
	 * 
	 * @param authorizationString
	 * @param category
	 * @param id
	 * @return status
	 */
	@PUT
	@Path("/UpdateCategory/{category}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateCategory(@HeaderParam("Authorization") String authorizationString,
			@PathParam("category") String category, @PathParam("id") String id) {

		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}

		Status status = categoryFacade.updateCategory(category, Integer.parseInt(id));
		return status;
	}
}
