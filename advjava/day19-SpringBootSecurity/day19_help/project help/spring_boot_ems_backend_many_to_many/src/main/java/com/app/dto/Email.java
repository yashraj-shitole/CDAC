package com.app.dto;


import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Email {
	@NotBlank
	private String recipient;
	@NotBlank
	private String msgBody;
	@NotBlank
	private String subject;
	private String attachment;
}
