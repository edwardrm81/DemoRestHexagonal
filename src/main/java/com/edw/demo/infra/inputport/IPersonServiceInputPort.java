package com.edw.demo.infra.inputport;

import java.util.List;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.domain.entity.PersonUser;

public interface IPersonServiceInputPort {

	public List<Person> getPersonListAll();
	public Person getPersonById(Integer id);
	public Person insertPerson(Person person);
	public Person updatePerson(Person person);
	public void deletePersonById(Integer id);
	
	public List<Person> getPersonByIdAndName(Integer id, String name);
	public List<Person> getListByIdAndName(Integer id, String name);
	public List<Person> getListByUserLogin(String login);
	
	public List<PersonUser> getPersonUserListByUserLogin(String login);
	
}
