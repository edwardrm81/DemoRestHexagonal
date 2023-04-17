package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.util.convert;

import com.edw.demo.domain.entity.PersonUser;

import jakarta.persistence.Tuple;

public class ConvertJpaTupleToDomainEntity {

	public static PersonUser personUserJpaTupleToPersonUserDomain(Tuple tuple) {
		return PersonUser.builder()
				.personName((String)tuple.get("personName"))
				.userLogin((String)tuple.get("userLogin"))
				.build();
	}
}
