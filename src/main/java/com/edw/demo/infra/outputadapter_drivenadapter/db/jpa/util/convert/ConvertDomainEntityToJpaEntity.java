package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.util.convert;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.entity.PersonJpaEntity;

public class ConvertDomainEntityToJpaEntity {

	public static PersonJpaEntity personDomainToPersonJpaEntity(Person personDomain) {
		return PersonJpaEntity.builder()
				.id(personDomain.getId())
				.name(personDomain.getName())
				.userId(personDomain.getUserId())
				.build();
	}
}
