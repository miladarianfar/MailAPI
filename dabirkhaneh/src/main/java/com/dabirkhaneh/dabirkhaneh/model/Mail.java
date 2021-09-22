package com.dabirkhaneh.dabirkhaneh.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String text;
	@ManyToOne(cascade = CascadeType.ALL)
	private User sender;
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<User> reciever = new ArrayList<User>();
	
	public Mail() {
	}

	public Mail(String subject, String text, User sender, List<User> reciever) {
		this.subject = subject;
		this.text = text;
		this.sender = sender;
		this.reciever = reciever;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public List<User> getReciever() {
		return reciever;
	}

	public void setReciever(List<User> reciever) {
		this.reciever = reciever;
	}
	
}
