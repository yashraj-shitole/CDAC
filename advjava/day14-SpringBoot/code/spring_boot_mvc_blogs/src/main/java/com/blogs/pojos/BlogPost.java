package com.blogs.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
