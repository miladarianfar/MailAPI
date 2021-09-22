package com.dabirkhaneh.dabirkhaneh.sevice;

import java.util.List;
import com.dabirkhaneh.dabirkhaneh.model.Mail;
import com.dabirkhaneh.dabirkhaneh.model.User;

public interface UserService {
	
	User getUser(String username);
	List<User> getUsers();
	List<Mail> getMails();
	Mail getMail(int id);
	
	Mail setRecievers(String username, int mailId);
	Mail setSender(String username, int mailId);
	
	User saveUser(User user);
	Mail saveMail(Mail mail);
	
	List<Mail> getUserMails(String username);
	List<Mail> getUserRecievedMails(String username);
	
	
}
