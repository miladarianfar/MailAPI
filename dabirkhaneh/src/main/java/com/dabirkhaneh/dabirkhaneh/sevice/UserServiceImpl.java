package com.dabirkhaneh.dabirkhaneh.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dabirkhaneh.dabirkhaneh.dao.MailRepository;
import com.dabirkhaneh.dabirkhaneh.dao.UserRepository;
import com.dabirkhaneh.dabirkhaneh.model.Mail;
import com.dabirkhaneh.dabirkhaneh.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MailRepository mailRepository;
	
	/**
	 * 
	 * @param username
	 * @return User
	 */
	@Override
	public User getUser(String username) {
		
		return userRepository.findByUsername(username);
	}

	/**
	 * 
	 * @return List of Users
	 */
	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

	/**
	 * 
	 * @return List of Mails
	 */
	@Override
	public List<Mail> getMails() {
		
		return mailRepository.findAll();
	}

	/**
	 * @param user
	 * @return User
	 */
	@Override
	public User saveUser(User user) {
		
		if(userRepository.findByUsername(user.getUsername()) != null) {
			throw new RuntimeException("User with username : " 
										+ user.getUsername() + " already exists!");
		}
		
		return userRepository.save(user);
	}

	/**
	 * 
	 * @param id
	 * @return Mail
	 */
	@Override
	public Mail getMail(int id) {
		
		return mailRepository.getById(id);
	}

	/**
	 * 
	 * @param mail
	 * @return Mail
	 */
	@Override
	public Mail saveMail(Mail mail) {
		
		mailRepository.save(mail);
		
		return mail;
	}

	/**
	 * 
	 * @param List of users
	 * @param mailId
	 * @return Mail
	 */
	@Override
	public Mail setRecievers(String username, int mailId) {
		
		Optional<Mail> mail = mailRepository.findById(mailId);
		
		User user = userRepository.findByUsername(username);
		
		mail.get().getReciever().add(user);
		
		mailRepository.save(mail.get());
		return mail.get();
	}

	/**
	 * 
	 * @param username
	 * @param mailId
	 * @return mail
	 */
	@Override
	public Mail setSender(String username, int mailId) {
		
		User user = userRepository.findByUsername(username);
		
		Optional<Mail> mail = mailRepository.findById(mailId);
		
		if(user == null || mail.get() == null) {
			throw new RuntimeException("user or mail not found!");
		}
		
		mail.get().setSender(user);
		mailRepository.save(mail.get());
		
		return mail.get();
	}
	
	/**
	 * 
	 * @param username
	 * @return List of Mails
	 */
	@Override
	public List<Mail> getUserMails(String username) {
		
		if(userRepository.findByUsername(username) == null) {
			throw new RuntimeException("User with username : " + username + " not found!");
		}
		
		List<Mail> mails = mailRepository.findAllBySenderUsername(username);
		
		return mails;
	}

	/**
	 * 
	 * @param username
	 * @return List of Mails
	 */
	@Override
	public List<Mail> getUserRecievedMails(String username) {
		
		List<Mail> mails = mailRepository.findAllByRecieverUsername(username);
		
		return mails;
	}

}


















