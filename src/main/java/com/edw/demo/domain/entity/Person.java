package com.edw.demo.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
	
	private Integer id;
	private String name;
	private Integer userId;
	
	public Person () {
	}
	
	public Person(Integer id, String name, Integer userId) {
		this.id = id;
		this.name = name;
		this.userId = userId;
	}

}
