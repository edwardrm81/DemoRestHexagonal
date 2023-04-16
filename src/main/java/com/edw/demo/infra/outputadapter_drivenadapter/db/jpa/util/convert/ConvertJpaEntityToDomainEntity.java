package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.util.convert;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.entity.PersonJpaEntity;

public class ConvertJpaEntityToDomainEntity {

	public static Person personJpaEntityToPersonDomain(PersonJpaEntity personJpaEntity) {
		return Person.builder()
				.id(personJpaEntity.getId())
				.name(personJpaEntity.getName())
				.userId(personJpaEntity.getUserId())
				.build();
	}
}
