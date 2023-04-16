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
@Table(name = "persons")
public class PersonJpaEntity {
	
	public PersonJpaEntity() {
	}
	
	public PersonJpaEntity(Integer id, String name, Integer userId) {
		this.id = id;
		this.name = name;
		this.userId = userId;
	}

	@Id
	private Integer id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "user_id")
	private Integer userId;
	
}
