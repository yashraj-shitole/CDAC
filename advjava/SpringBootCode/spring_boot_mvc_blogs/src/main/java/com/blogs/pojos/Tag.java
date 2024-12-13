package com.blogs.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tag extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;
	//Tag *---->* BlogPost
	@ManyToMany //mandatory
	@JoinTable(name="my_tag_posts",joinColumns = @JoinColumn(name="tag_id"),
	inverseJoinColumns = @JoinColumn(name="post_id"))
	private Set<BlogPost> posts=new HashSet<>();

	public Tag(String name) {
		super();
		this.name = name;
	}

}
