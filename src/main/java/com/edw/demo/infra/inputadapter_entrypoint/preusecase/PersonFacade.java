package com.edw.demo.infra.inputadapter_entrypoint.preusecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.domain.entity.PersonUser;
import com.edw.demo.infra.inputadapter_entrypoint.preusecase.interfaces.IPersonFacade;
import com.edw.demo.infra.inputport.IPersonServiceInputPort;

@Component
public class PersonFacade implements IPersonFacade{

	@Autowired
	private IPersonServiceInputPort personService;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Person> personListAll() throws Throwable {
		return personService.getPersonListAll();	
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Person getPersonById(Integer id) throws Throwable {
		return personService.getPersonById(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Person insertPerson(Person person) throws Throwable {
		return personService.insertPerson(person);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Person updatePerson(Person person) throws Throwable {
		return personService.updatePerson(person);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deletePersonById(Integer id) throws Throwable {
		personService.deletePersonById(id);	
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Person> getPersonByIdAndName(Integer id, String name) throws Throwable {
		return personService.getPersonByIdAndName(id, name);	
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Person> getListByIdAndName(Integer id, String name) throws Throwable {
		return personService.getListByIdAndName(id, name);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Person> getListByUserLogin(String login) throws Throwable {
		return personService.getListByUserLogin(login);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<PersonUser> getPersonUserListByUserLogin(String login) throws Throwable {
		return personService.getPersonUserListByUserLogin(login);
	}
}
