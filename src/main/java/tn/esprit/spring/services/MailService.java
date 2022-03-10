package tn.esprit.spring.services;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Evenement;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service

public class MailService {
/*	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	/*@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * This function is used to send mail without attachment.
	 * @param user
	 * @throws MailException
	 */

	

	/*public void sendWarningEmail(Entreprise entreprise) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		/*SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(entreprise.getEmail());
		mail.setSubject("DAHLIA BAN Warning");
		mail.setText("You have recieved a BAN warning due to an appointment report assigned by a user.");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		/*javaMailSender.send(mail);
	}

	*/
	


}
