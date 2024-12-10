package com.cdac.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

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
	// id prop MUST be - Serializable
	@Id // PK
		// For auto ID generation using auto increment constraint -
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column // column name - user_id
	private Long id; // mapped to PK
	// creation date
	@CreationTimestamp
	@Column(name="created_on")
	private LocalDate createdOn;
	// updataion time stamp
	@UpdateTimestamp
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
//	@Version //used for optimistic locking
//	private int entityVersion;

}
