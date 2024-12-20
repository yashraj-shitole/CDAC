// Java Program to Illustrate Creation Of
// Service implementation class

package com.app.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.Email;

// Annotation
@Service
// Class
// Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") //extracting a pvalue of the property added in application.properties file
	private String sender;

	@Async // This method will work asynchronously , on a separate thread
	public void sendSimpleMail(Email details) {
		System.out.println("send mail invoked by " + Thread.currentThread());
		// Creating a simple mail message
		SimpleMailMessage emailMessage = new SimpleMailMessage();
		// adding the details
		emailMessage.setFrom(sender);
		emailMessage.setTo(details.getRecipient());
		emailMessage.setText(details.getMsgBody());
		emailMessage.setSubject(details.getSubject());
		// Sending the mail : time consuming task
		javaMailSender.send(emailMessage);
		System.out.println("Mail Sent Successfully...");
	}

	// To send an email with attachment
	@Async
	public void sendMailWithAttachment(Email details) throws MessagingException {
		System.out.println("send mail with attachment invoked by " + Thread.currentThread());

		// Create a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		// Setting multipart as true for attachments to be sent
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom(sender);
		mimeMessageHelper.setTo(details.getRecipient());
		mimeMessageHelper.setText(details.getMsgBody());
		mimeMessageHelper.setSubject(details.getSubject());
		// Adding the attachment , from the local file system
		FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));
		mimeMessageHelper.addAttachment(file.getFilename(), file);

		// Sending the mail with attachment
		javaMailSender.send(mimeMessage);
		System.out.println("Mail Sent Successfully with attachment");
	}

}
