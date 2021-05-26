package jeeexample.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = Message.GET_ALL_MESSAGES, query = "SELECT p FROM Message p"),
	@NamedQuery(name = Message.GET_ALL_MESSAGES_IDS, query = "SELECT p.id FROM Message p"),
	@NamedQuery(name = Message.GET_MESSAGES_COUNT, query = "SELECT COUNT(p.id) FROM Message p"),
})
public class Message extends Entity_ {

	public static final String GET_ALL_MESSAGES = "getAllMessages";
	public static final String GET_ALL_MESSAGES_IDS = "getAllMessagesIds";
	public static final String GET_MESSAGES_COUNT = "getMessagesCount";

	private static final long serialVersionUID = 1L;
	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
