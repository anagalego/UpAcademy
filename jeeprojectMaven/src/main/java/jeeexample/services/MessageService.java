package jeeexample.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import jeeexample.models.Message;
import jeeexample.repositories.MessageRepository;

@RequestScoped
@Path("api/message")
public class MessageService extends EntityService<MessageRepository, Message> {
	
	@Inject
	protected MessageRepository DBS;

}
