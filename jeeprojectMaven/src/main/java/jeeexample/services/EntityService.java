package jeeexample.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import jeeexample.models.Entity_;
import jeeexample.repositories.EntityRepository;

public abstract class EntityService<T extends EntityRepository<R>, R extends Entity_> {

	@Inject
	protected T repository;

	@Context
	protected UriInfo context;

	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<R> getAll() {
		return repository.getAll();
	}

	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return repository.getAllIds();
	}

	@GET
	@Path("count")
	@Produces(MediaType.APPLICATION_JSON)
	public long count() {
		return repository.size();
	}

	@GET
	@Path("time")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(R entity) {
		repository.addEntity(entity);
		return Response.ok().build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public R get(@PathParam("id") long id) {
		R entity = repository.getEntity(id);
		return entity;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(R entity) {
		repository.editEntity(entity);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) {
		repository.removeEntity(id);
		return Response.ok().build();
	}
	
}
