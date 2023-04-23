package com.edw.demo.application_usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.domain.entity.PersonUser;
import com.edw.demo.infra.inputport.IPersonServiceInputPort;
//import com.edw.demo.infra.outputport.IPersonRepositoryJPAOutputPort;
import com.edw.demo.infra.outputport.IPersonRepositoryOutputPort;

@Service
public class PersonService implements IPersonServiceInputPort {
	
	@Autowired 
	//@Qualifier("PersonDBSimulator")
	@Qualifier("PersonDBJPA")
	private IPersonRepositoryOutputPort personRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Person> getPersonListAll() {
		return personRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Person getPersonById(Integer id) {
		return personRepository.findById(id);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Person insertPerson(Person person) {
		return personRepository.create(person);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Person updatePerson(Person person) {
		return personRepository.update(person);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deletePersonById(Integer id) {
		personRepository.deleteById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Person> getPersonByIdAndName(Integer id, String name) {
		return personRepository.findByIdAndName(id, name);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Person> getListByIdAndName(Integer id, String name) {
		return personRepository.getListByIdAndName(id, name);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Person> getListByUserLogin(String login) {
		return personRepository.getListByUserLogin(login);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<PersonUser> getPersonUserListByUserLogin(String login) {
		return personRepository.getPersonUserListByUserLogin(login);
	}
	
}
