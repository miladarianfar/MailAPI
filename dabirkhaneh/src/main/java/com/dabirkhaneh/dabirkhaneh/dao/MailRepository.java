package com.dabirkhaneh.dabirkhaneh.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dabirkhaneh.dabirkhaneh.model.Mail;

public interface MailRepository extends JpaRepository<Mail, Integer> {
	
	@Query("from Mail m left join m.sender MailSen where MailSen.username =:username")
	List<Mail> findAllBySenderUsername(@Param("username") String username);
	
	@Query("from Mail m left join m.reciever MailRec where MailRec.username =:username")
	List<Mail> findAllByRecieverUsername(@Param("username") String username);
}
