// Java Program to Illustrate Creation Of
// Service Interface

package com.app.service;

import javax.mail.MessagingException;

import com.app.dto.ApiResponse;
import com.app.dto.Email;

// Importing required classes

// Interface
public interface EmailService {

	// To send a simple email(w/o attachement)
	void sendSimpleMail(Email details);

	// To send an email with attachment
	void sendMailWithAttachment(Email details) throws MessagingException;
}
