package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.entity.PersonJpaEntity;

public interface IPersonJPA extends JpaRepository <PersonJpaEntity, Integer>{ 

	public List<PersonJpaEntity> findByIdAndName(Integer id, String name);
}
