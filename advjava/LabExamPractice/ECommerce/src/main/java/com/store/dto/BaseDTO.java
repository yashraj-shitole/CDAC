package com.store.dto;

import java.lang.invoke.VarHandle.AccessMode;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime createdOn;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime updatedOn;
	
}
