package com.edw.demo.application_usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edw.demo.domain.entity.Person;
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
	public List<Person> getPersonListAll() {
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(Integer id) {
		return personRepository.findById(id);
	}
	
	@Override
	public Person insertPerson(Person person) {
		return personRepository.create(person);
	}
	
	@Override
	public Person updatePerson(Person person) {
		return personRepository.update(person);
	}
	
	@Override
	public void deletePersonById(Integer id) {
		personRepository.deleteById(id);
	}

	@Override
	public List<Person> getPersonByIdAndName(Integer id, String name) {
		return personRepository.findByIdAndName(id, name);
	}
	
	@Override
	public List<Person> getListByIdAndName(Integer id, String name) {
		return personRepository.getListByIdAndName(id, name);
	}
	
	@Override
	public List<Person> getListByUserLogin(String login) {
		return personRepository.getListByUserLogin(login);
	}
	
}
