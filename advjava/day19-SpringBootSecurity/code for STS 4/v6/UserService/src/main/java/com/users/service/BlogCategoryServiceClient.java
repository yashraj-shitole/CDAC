package com.users.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.users.dto.BlogPostRespDTO;

//@FeignClient(url="http://localhost:8081/posts" , value = "Blogs-Category-Service")
@FeignClient(name="Blogs-Category-Service") 
public interface BlogCategoryServiceClient {
	
	@GetMapping("/posts/blogger/{bloggerId}")
	List<BlogPostRespDTO> getPostByAuthor(@PathVariable Long bloggerId);

}
