package com.blogs.pojos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
