package com.blogs.pojos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude ="blogPosts")
public class Category extends BaseEntity {
	@Column(name = "category_name", unique = true, length = 30)
	private String categoryName;
	private String description;
	// Catgeory 1--->* BlogPost
	// Category - one , parent, inverse
	/*
	 * mappedBy : property of @OneToMany annotation Mandatory in - in a bi dir
	 * association Appears in - inverse side value = name of the property from
	 * owning side Otherwise , since hibernate can't figure out about the owning n
	 * inverse sides , it simply create additional table , having compsite PK
	 */
	//@JsonIgnore//=>annotation meant for Jackson(default HTTP mesg converter
	//) to skip the property / field during both ser n de-ser.
	@OneToMany(mappedBy = "blogCategory",cascade = CascadeType.ALL,
			orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<BlogPost> blogPosts = new ArrayList<>();

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}

	// Helper methods
	public void addBlogPost(BlogPost post) {
		this.blogPosts.add(post);
		post.setBlogCategory(this);
	}

	public void removeBlogPost(BlogPost post) {
		this.blogPosts.remove(post);
		post.setBlogCategory(null);
	}
}
