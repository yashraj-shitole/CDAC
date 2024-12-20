package com.blogs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(value = Include.NON_NULL)
public class DataDto {
	private Integer id;
	private String name;
	private Data data;
}
