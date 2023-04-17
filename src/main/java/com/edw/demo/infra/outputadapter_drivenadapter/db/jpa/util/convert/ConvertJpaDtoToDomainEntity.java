package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.util.convert;

import com.edw.demo.domain.entity.PersonUser;
import com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.dto.PersonUserJpaDto;

public class ConvertJpaDtoToDomainEntity {

	public static PersonUser personUserJpaDtoToPersonUserDomain(PersonUserJpaDto personUserJpaDto) {
		return PersonUser.builder()
				.personName(personUserJpaDto.getPersonName())
				.userLogin(personUserJpaDto.getUserLogin())
				.build();
	}
}
