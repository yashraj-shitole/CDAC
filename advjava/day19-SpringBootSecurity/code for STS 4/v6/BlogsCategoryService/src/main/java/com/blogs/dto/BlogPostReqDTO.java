package com.blogs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogPostReqDTO extends BaseDTO{
	private Long categoryId;
	private Long bloggerId;
	private String title;
	private String description;
	private String content;
}
