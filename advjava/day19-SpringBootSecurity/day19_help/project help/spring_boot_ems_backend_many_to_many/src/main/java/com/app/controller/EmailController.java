package com.app.controller;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Email;
import com.app.service.EmailService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/mail")
public class EmailController {
	// depedency
	@Autowired
	private EmailService emailService;

	// Sending a simple Email w/o attachments
	@PostMapping
	@Operation(summary = "Sending a simple Email w/o attachments")
	public ResponseEntity<?> sendMail(@RequestBody @Valid Email email) {
		System.out.println("in send mail " + email + " invoker " + Thread.currentThread());
		emailService.sendSimpleMail(email);
		return ResponseEntity.ok("Sending mail in async manner");
	}

	// Sending email with attachment
	@PostMapping("/attachment")
	@Operation(summary = "Sending an  Email with attachments")
	public ResponseEntity<?> sendMailWithAttachment(@RequestBody Email email) throws MessagingException {
		System.out.println("in send mail with attachment " + email + " invoker " + Thread.currentThread());
		emailService.sendMailWithAttachment(email);
		return ResponseEntity.ok("Sending mail with attachments in sync manner");
	}
}
