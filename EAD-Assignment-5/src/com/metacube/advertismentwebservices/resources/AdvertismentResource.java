package com.metacube.advertismentwebservices.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.metacube.advertismentwebservices.model.Advertisement;
import com.metacube.advertismentwebservices.Common.Status;
import com.metacube.advertismentwebservices.facade.AdvertisementFacade;

@Path("/Advertisement")
public class AdvertismentResource {
	AdvertisementFacade advertisementFacade = AdvertisementFacade.getInstance();

	/**
	 * Function to insert data in database table
	 * 
	 * @param id
	 * @param name
	 * @return status
	 */
	@POST
	@Path("/InsertAdvertisement")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status insertIntoAdvertisement(
			@HeaderParam("Authorization") String authorizationString,
			Advertisement advertisement) {

		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}
		Status status = advertisementFacade.insertAdvertisement(
				advertisement.getCategory_id(), advertisement.getTitle(),
				advertisement.getDescription());
		return status;
	}

	/**
	 * Function to get data from database table
	 * 
	 * @return json data
	 */
	@GET
	@Path("/GetAdvertisment")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisement(
			@HeaderParam("Authorization") String authorizationString) {

		if (!"GET-2018".equals(authorizationString)) {
			return "" + Status.ERROR;
		}

		List<Advertisement> advertismentList = advertisementFacade.getAll();
		Gson gson = new Gson();
		String advertismnetJson = gson.toJson(advertismentList);
		return advertismnetJson;
	}

	/**
	 * Function to get data from database table by id
	 * 
	 * @param id
	 * @return json data
	 */
	@GET
	@Path("/GetAdvertismentById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisementById(
			@HeaderParam("Authorization") String authorizationString,
			@PathParam("id") String id) {

		if (!"GET-2018".equals(authorizationString)) {
			return "" + Status.ERROR;
		}

		List<Advertisement> advertismentList = advertisementFacade
				.getAllById(Integer.parseInt(id));
		Gson gson = new Gson();
		String advertismnetJson = gson.toJson(advertismentList);
		return advertismnetJson;
	}

	/**
	 * Function for updating name of the advertisement
	 * 
	 * @param authorizationString
	 * @param id
	 * @param title
	 * @return status
	 */
	@PUT
	@Path("/UpdateAdvertisement/{id}/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateAdvertisementName(
			@HeaderParam("Authorization") String authorizationString,
			@PathParam("id") String id, @PathParam("title") String title) {

		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}

		Status status = advertisementFacade.updateName(title,
				Integer.parseInt(id));
		return status;
	}

	/**
	 * Function for deleting advertisement
	 * 
	 * @param authorizationString
	 * @param id
	 * @return status
	 */
	@DELETE
	@Path("/DeleteAdvertisementById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteAdvertisementById(
			@HeaderParam("Authorization") String authorizationString,
			@PathParam("id") int id) {

		if (!"GET-2018".equals(authorizationString)) {
			return Status.ERROR;
		}

		Status status = advertisementFacade.deleteAdvertisement(id);
		return status;
	}

}
