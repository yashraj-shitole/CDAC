package com.app.pojos;

import javax.persistence.Access;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass // to tell hib , not to create any tables n other entities will extend from it\
@Getter
@Setter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JsonProperty(access =Access.READ_ONLY)
	private Long id;
	

	
}
