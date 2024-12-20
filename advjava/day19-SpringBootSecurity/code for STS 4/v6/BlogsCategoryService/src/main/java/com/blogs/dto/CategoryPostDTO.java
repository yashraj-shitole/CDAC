package com.blogs.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryPostDTO extends BaseDTO{
	private String categoryName;
	private String description;
	private List<BlogPostRespDTO> posts;
}
