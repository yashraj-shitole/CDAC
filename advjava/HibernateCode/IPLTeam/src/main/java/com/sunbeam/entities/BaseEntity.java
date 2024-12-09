package com.sunbeam.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	@Column
	private Long id;
	
	@CreationTimestamp
	@Column(name ="created_on")
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column(name = "updates_on")
	private LocalDateTime updatedOn;

}
