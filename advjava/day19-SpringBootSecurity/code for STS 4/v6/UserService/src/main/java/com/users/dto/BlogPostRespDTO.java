package com.users.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogPostRespDTO {
	private Long id;
	private LocalDate createdOn;
	private LocalDateTime updatedOn;
	private String title;
	private String description;
	private String content;
}
