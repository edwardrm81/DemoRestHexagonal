package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.entity.UserJpaEntity;

public interface IUserJPA extends JpaRepository <UserJpaEntity, Integer>{ 

	public List<UserJpaEntity> findByLogin(String login);
	//public List<UserJpaEntity> buscarLoginAndPassword(String login, String password);
}
