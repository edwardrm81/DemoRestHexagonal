package com.edw.demo.infra.outputadapter_drivenadapter.db.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.entity.PersonJpaEntity;
import com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.util.convert.ConvertDomainEntityToJpaEntity;
import com.edw.demo.infra.outputadapter_drivenadapter.db.jpa.util.convert.ConvertJpaEntityToDomainEntity;
import com.edw.demo.infra.outputport.IPersonRepositoryOutputPort;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository("PersonDBJPA")
public class PersonDBJPA implements IPersonRepositoryOutputPort{
	
	@PersistenceContext private EntityManager em;
	
	@Autowired
	private IPersonJPA personJPA;  
	
	
	@Override
	public List<Person> findAll() {
		List<Person> personList = new ArrayList<>();
		for (PersonJpaEntity personJpaEntity : personJPA.findAll()) {
			Person person = ConvertJpaEntityToDomainEntity.personJpaEntityToPersonDomain(personJpaEntity);
			personList.add(person);
		}
		return personList;
	}

	@Override
	public Person findById(Integer id) {
		//PersonJpaEntity personEntity = personJPA.findById(id).orElseThrow( ()-> new DBException("personJPA ("+id+")"+" not found") );
		PersonJpaEntity personJpaEntity = personJPA.findById(id).orElse(null);
		return null != personJpaEntity? ConvertJpaEntityToDomainEntity.personJpaEntityToPersonDomain(personJpaEntity) : null;
	}

	@Override
	public Person create(Person person) {
		PersonJpaEntity personJpaEntity = personJPA.save(ConvertDomainEntityToJpaEntity.personDomainToPersonJpaEntity(person));
		return ConvertJpaEntityToDomainEntity.personJpaEntityToPersonDomain(personJpaEntity);
	}
	
	@Override
	public Person update(Person person) {
		PersonJpaEntity personJpaEntity = personJPA.save(ConvertDomainEntityToJpaEntity.personDomainToPersonJpaEntity(person));
		return ConvertJpaEntityToDomainEntity.personJpaEntityToPersonDomain(personJpaEntity);
	}
	
	@Override
	public void deleteById(Integer id) {
		personJPA.deleteById(id);
	}

	/*
	 * Consulta usando la interfaz JpaRepository
	 */
	@Override
	public List<Person> findByIdAndName(Integer id, String name) {
		List<Person> personList = new ArrayList<>();
		for (PersonJpaEntity personJpaEntity : personJPA.findByIdAndName(id, name)) {
			Person person = ConvertJpaEntityToDomainEntity.personJpaEntityToPersonDomain(personJpaEntity);
			personList.add(person);
		}
		return personList;
	}
	
	/*
	 * Consulta usando un NativeQuery
	 */
	public List<Person> getListByIdAndName(Integer id, String name) {
		List<Person> personList = new ArrayList<>();
		String sqlString = "SELECT * FROM persons WHERE id = :id AND name = :name";
		Query nativeQuery = em.createNativeQuery(sqlString, PersonJpaEntity.class);
		nativeQuery.setParameter("id", id);
		nativeQuery.setParameter("name", name);
		//PersonJpaEntity personJpaEntity = (PersonJpaEntity) nativeQuery.getSingleResult();
		for (PersonJpaEntity personJpaEntity : (List<PersonJpaEntity>)nativeQuery.getResultList()) {
			Person person = ConvertJpaEntityToDomainEntity.personJpaEntityToPersonDomain(personJpaEntity);
			personList.add(person);
		}
		
		return personList;
	}

	@Override
	public List<Person> getListByUserLogin(String login) {
		List<Person> personList = new ArrayList<>();
		String sqlString = "SELECT p.id, p.name, p.user_id FROM persons p "
				+ "LEFT JOIN users u ON (u.id = p.user_id) "
				+ "WHERE u.login = :login";
		Query nativeQuery = em.createNativeQuery(sqlString, PersonJpaEntity.class);
		nativeQuery.setParameter("login", login);
		for (PersonJpaEntity personJpaEntity : (List<PersonJpaEntity>)nativeQuery.getResultList()) {
			Person person = ConvertJpaEntityToDomainEntity.personJpaEntityToPersonDomain(personJpaEntity);
			personList.add(person);
		}
		
		return personList;
	}
	
	

}
