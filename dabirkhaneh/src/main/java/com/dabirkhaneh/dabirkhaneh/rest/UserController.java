package com.dabirkhaneh.dabirkhaneh.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dabirkhaneh.dabirkhaneh.model.Mail;
import com.dabirkhaneh.dabirkhaneh.model.User;
import com.dabirkhaneh.dabirkhaneh.sevice.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;
	
	/**
	 * 
	 * @return all users
	 */
	@CrossOrigin
	@GetMapping("/users")
	public List<User> getUsers(){
		
		return service.getUsers();
	}
	
	/**
	 * 
	 * @return all mails
	 */
	@CrossOrigin
	@GetMapping("/mails")
	public List<Mail> getMails(){
		
		return service.getMails();
	}
	
	/**
	 * 
	 * @param mailId
	 * @return mail with id =:mailId
	 */
	@CrossOrigin
	@GetMapping("/mail/{mailId}")
	public Mail getMail(@PathVariable("mailId") int mailId) {
		
		return service.getMail(mailId);
	}
	
	/**
	 * 
	 * @param username
	 * @return user with username =:username
	 */
	@CrossOrigin
	@GetMapping("/user/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return service.getUser(username);
	}
	
	/**
	 * 
	 * @param user
	 * @return saved user
	 */
	@CrossOrigin
	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user) {
		
		return service.saveUser(user);
	}
	
	/**
	 * 
	 * @param username
	 * @param mail
	 * @return
	 */
	@CrossOrigin
	@PostMapping("/mail/save")
	public Mail saveMail(@RequestBody Mail mail) {
		
		service.saveMail(mail);
		
		return mail;
	}
	
	/**
	 * 
	 * @param mailId
	 * @param reciever
	 * @return mail
	 */
	@CrossOrigin
	@GetMapping("/mail/set-recievers/{username}/{mailId}")
	public Mail setRecievers(@PathVariable("username") String username,
							@PathVariable("mailId") int mailId) {
		
		service.setRecievers(username, mailId);
		
		return service.getMail(mailId);
	}
	
	/**
	 * 
	 * @param username
	 * @param mailId
	 * @return mail
	 */
	@CrossOrigin
	@GetMapping("/mail/set-sender/{username}/{mailId}")
	public Mail setSender(@PathVariable("username") String username, @PathVariable("mailId") int mailId) {
		
		service.setSender(username, mailId);
		
		return service.getMail(mailId);
	}
	
	/**
	 * 
	 * @param username
	 * @return List of sent mails from user with username =:username
	 */
	@CrossOrigin
	@GetMapping("/mails/user-sent-mails/{username}")
	public List<Mail> getUserMails(@PathVariable("username") String username){
		
		return service.getUserMails(username);
	}
	
	/**
	 * 
	 * @param username
	 * @return List of recieved mails for user with username =:username
	 */
	@GetMapping("/mails/user-recieved-mails/{username}")
	public List<Mail> getUserRecievedMails(@PathVariable("username") String username){
		
		return service.getUserRecievedMails(username);
	}
}




















