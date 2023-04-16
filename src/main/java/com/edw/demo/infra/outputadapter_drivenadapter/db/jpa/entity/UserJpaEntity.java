package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder //Para poder agregar el Builder en una entidad JPA y que funcione correctamente, requiere que agregue el constructor vacio y el constructor con todos los atributos
@Data
@Entity
@Table(name = "users")
public class UserJpaEntity {
	
	public UserJpaEntity() {
	}
	
	public UserJpaEntity(Integer id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	@Id
	private Integer id;
	
	@Column(name = "login", length = 50)
	private String login;
	
	@Column(name = "password", length = 50)
	private String password;
	
}
