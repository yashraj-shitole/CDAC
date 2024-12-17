package com.blogs.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude = {"blogCategory","blogger"})
@EqualsAndHashCode(of="title",callSuper = false)
public class BlogPost extends BaseEntity {
	@Column(unique = true, length = 30)
	private String title;
	private String description;
	@Column(length = 500)
	private String content;
	//to support soft delete - add status field
	private boolean status;
	//BlogPost *--->1 Category
	//BlogPost - many, child , owning
	@ManyToOne 
	@JoinColumn(name="category_id",nullable = false)
	private Category blogCategory;
	//BlogPost ---> Blogger (uni dir association many ---> one)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable = false) //FK blogger_id
	private User blogger;
	
		public BlogPost(String title, String description, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}	
}
