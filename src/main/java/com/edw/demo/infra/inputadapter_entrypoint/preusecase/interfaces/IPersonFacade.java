package com.edw.demo.infra.inputadapter_entrypoint.preusecase.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.domain.entity.PersonUser;
import com.edw.demo.infra.inputport.IPersonServiceInputPort;

public interface IPersonFacade {
	
	public List<Person> personListAll() throws Throwable;
	public Person getPersonById(Integer id) throws Throwable;
	public Person insertPerson(Person person) throws Throwable;
	public Person updatePerson(Person person) throws Throwable;
	public void deletePersonById(Integer id) throws Throwable;	
	public List<Person> getPersonByIdAndName(Integer id, String name) throws Throwable;
	public List<Person> getListByIdAndName(Integer id, String name) throws Throwable;
	public List<Person> getListByUserLogin(String login) throws Throwable;
	public List<PersonUser> getPersonUserListByUserLogin(String login) throws Throwable;
		
}
