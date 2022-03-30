package com.deguzman.DeGuzmanStuffAnywhere.email_service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendEmail(String username, String email) throws Exception {
		
		String emailTextBody = "Welcome to DeGuzmanStuffAnywhere: " + username + "." + "Upon receipt of this email, please log in to application";
		
		String emailTextSubject = "Welcome to DSA";
		
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setTo(email);
		helper.setText(emailTextBody);
		helper.setSubject(emailTextSubject);
		
		
		sender.send(message);
	}
}
