package com.blogs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@ToString(callSuper = true, exclude = "selectedCategory")
@EqualsAndHashCode(of = "title", callSuper = false)
public class BlogPost extends BaseEntity {
	@Column(length = 30, unique = true)
	private String title;
	private String description;
	private String content;
	// BlogPost *--->1 Category
	@ManyToOne
	// to customize FK col name n not null constraint
	@JoinColumn(name = "category_id", nullable = false)
	private Category selectedCategory;
	//for the blogger
	private Long bloggerId;

	public BlogPost(String title, String description, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}

}
