package com.sunbeam.iplteam.pojos;

import java.time.LocalDate;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	@Column(name="created_on")
	private LocalDate createdOn;
	@UpdateTimestamp
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
}

