package jeeexample.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jeeexample.models.User;
import jeeexample.repositories.UserRepository;


@RequestScoped
@Path("api/user")
public class UserService extends EntityService<UserRepository, User> {
	
	@Inject
	protected UserRepository DBP;
	

	@POST
	@Path("setName")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String saveUserFullName(User user) {
		user.setName();
		repository.addEntity(user);
		return user.getName();
	}
}
