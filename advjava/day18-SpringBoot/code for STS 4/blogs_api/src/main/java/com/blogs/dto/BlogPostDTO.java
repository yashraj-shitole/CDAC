package com.blogs.dto;

import com.blogs.pojos.Category;
import com.blogs.pojos.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class BlogPostDTO  {
	private String title;
	private String description;	
	private String content;
	private Long categoryId;
	private Long bloggerId;	
}
