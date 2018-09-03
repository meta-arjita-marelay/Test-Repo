package com.resources;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.dao.AdvertisementDao;
import com.entity.Advertisement;
import com.facade.AdvertisementFacade;
@Path("/AdvertisementResource")
public class AdvertisementResource {
	AdvertisementFacade advertismentFacade=AdvertisementFacade.getInstance();
	
	
	@GET
	@Path("/GetAdvertisment")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisement() {
		List<Advertisement> advertismentList=advertismentFacade.getAll();
		Gson gson = new Gson();
		String advertismnetJson=gson.toJson(advertismentList);
		return advertismnetJson;
	}
	
	
	@GET
	@Path("/GetAdvertismentById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisementById(@PathParam("id") String id) {
		List<Advertisement> advertismentList=advertismentFacade.getAllById(Integer.parseInt(id));
		Gson gson = new Gson();
		String advertismnetJson=gson.toJson(advertismentList);
		return advertismnetJson;
	}
	
	
	@GET
	@Path("/UpdateAdvertisement/{id}/{title}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAdvertisementName(@PathParam("id")String id,@PathParam("title") String title){
		advertismentFacade.updateName(title, Integer.parseInt(id));
		return "Upadted";
	}
	
}
