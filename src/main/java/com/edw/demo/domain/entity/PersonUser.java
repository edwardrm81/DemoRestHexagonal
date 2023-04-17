package com.edw.demo.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonUser {
	
	private String personName;
	private String userLogin;
	
	public PersonUser () {
	}
	
	public PersonUser(String personName, String userLogin) {
		this.personName = personName;
		this.userLogin = userLogin;
	}

}
