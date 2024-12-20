package com.blogs.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@ToString(callSuper = true,exclude ="posts")
public class Category extends BaseEntity {
	@Column(/* name = "name", */length = 30, unique = true)
	private String categoryName;
	private String description;
	// Category 1--->* BlogPost
	//one , parent , non owning (since it doesn't contain FK)
	/*
	 * mappedBy - mandatory in bi dir association between entities
	 * appears in inverse (non owning)
	 * value=name of the property from owning side
	 * def fetch type for any to many - LAZY
	 * while accessing un-fetched data(i.e a proxy) outside of the session scope
	 * hibernate throws - LazyInitializationException 
	 * orphanRemoval =true => Tells hibernate delete the record from the DB,
	 * the moment it's removed from association
	 */
	//@JsonIgnore //to tell Jackson , to ignore this field , during ser n de-ser.
	@OneToMany(mappedBy = "selectedCategory", 
			cascade = CascadeType.ALL /* ,fetch = FetchType.EAGER */ ,
			orphanRemoval = true)
	private List<BlogPost> posts = new ArrayList<>();


	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}


	// add helper method in the entity layer to establish bi-dir association between
//	// Category n post
	public void addBlogPost(BlogPost post) {
		// establish category --> post (parent --> child)
		this.posts.add(post);
		// establish post --> category (child -> parent)
		post.setSelectedCategory(this);
	}
	// add helper method in the entity layer to un - establish bi-dir association
	// between Category n post
	public void removeBlogPost(BlogPost post) {
		this.posts.remove(post);
		post.setSelectedCategory(null);
	}

	

}
