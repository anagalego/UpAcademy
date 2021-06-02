package io.altar.LibraryMaven.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.altar.LibraryMaven.models.Shelf;
import io.altar.LibraryMaven.repositories.ShelfRepository;
import io.altar.LibraryMaven.services.ShelfService;

@RequestScoped
@Path("shelves")
public class ShelfController extends EntityController<ShelfService, ShelfRepository, Shelf> {
	

	
	@GET
	@Path("empty")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shelf> getEmpty() {
		return service.getEmpty();
	}
	
	@GET
	@Path("product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shelf> getShelvesWithProduct(@PathParam("id") long id){
		return service.getShelvesWithProduct(id);
	}
	
	@PUT
	@Path("emptyShelf")
	@Produces(MediaType.APPLICATION_JSON)
	public void emptyShelf() {	
		service.emptyShelf();
	}
	
	@PUT
	@Path("emptyShelf/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String emptyShelf(@PathParam("id") long id) {	
		return service.emptyShelf(id);
	}
	
	@PUT
	@Path("/emptyShelfWithProduct/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void emptyShelfWithProduct(@PathParam("id") long id) {
		service.emptyShelfWithProduct(id);
	}
	
	@PUT
	@Path("/addProduct/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf addProduct(@PathParam("id") long id, @QueryParam("productId") long productId){
		return service.addProduct(id, productId);
	}
	
}
