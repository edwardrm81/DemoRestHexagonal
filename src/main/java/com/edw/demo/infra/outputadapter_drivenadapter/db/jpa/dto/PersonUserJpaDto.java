package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonUserJpaDto {
	
	private String personName;
	private String userLogin;
	
	public PersonUserJpaDto () {
	}
	
	public PersonUserJpaDto(String personName, String userLogin) {
		this.personName = personName;
		this.userLogin = userLogin;
	}

}
