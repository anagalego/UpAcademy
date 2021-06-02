package io.altar.LibraryMaven.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.LibraryMaven.models.Entity_;
import io.altar.LibraryMaven.repositories.EntityRepository;
import io.altar.LibraryMaven.services.EntityService;

public abstract class EntityController<S extends EntityService<R,E>, R extends EntityRepository<E>, E extends Entity_> {

	@Inject
	protected S service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public E addEntity(E entity) {
		return service.addEntity(entity);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<E> getAll() {
		return service.getAll();
	}
	
	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return service.getAllIds();
	}
	
	@GET
	@Path("size")
	@Produces(MediaType.APPLICATION_JSON)
	public long size() {
		return service.size();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public E get(@PathParam("id") long id) {
		return service.getEntity(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public E update(E entity) {
		return service.editEntity(entity);
	}

	@DELETE
	@Path("/{id}")
	public String delete(@PathParam("id") long id) {
		return service.delete(id);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String clear() {
		String removed = service.getAllIds().toString();
		service.clear();
		return "Id/s " + removed + " removidos com sucesso.";
	}
}
