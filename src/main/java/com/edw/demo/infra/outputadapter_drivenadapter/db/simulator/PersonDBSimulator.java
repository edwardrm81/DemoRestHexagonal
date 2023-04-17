package com.edw.demo.infra.outputadapter_drivenadapter.db.simulator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.domain.entity.PersonUser;
import com.edw.demo.infra.outputport.IPersonRepositoryOutputPort;

@Repository("PersonDBSimulator")
public class PersonDBSimulator implements IPersonRepositoryOutputPort{

	@Override
	public List<Person> findAll() {
		List<Person> personList = new ArrayList<>();
		
		Person person1 = Person.builder()
				.id(1)
				.name("Edward")
				.build();
		personList.add(person1);
		
		Person person2 = new Person(2, "Rodriguez", 1);
		personList.add(person2);
		
		return personList;
	}

	@Override
	public Person findById(Integer id) {
		Person person = new Person();
		person.setId(id);
		person.setName("Rodriguez"+id);
		
		return person;
	}

	@Override
	public Person create(Person person) {
		return person;
	}
	
	@Override
	public Person update(Person person) {
		return person;
	}
	
	@Override
	public void deleteById(Integer id) {
	}

	@Override
	public List<Person> findByIdAndName(Integer id, String name) {
		
		List<Person> personList = new ArrayList<>();
		
		Person person1 = new Person(id, name, 1);
		personList.add(person1);
		Person person2 = new Person(id, name, 3);
		personList.add(person2);
		
		return personList;
	}

	@Override
	public List<Person> getListByIdAndName(Integer id, String name) {
		List<Person> personList = new ArrayList<>();
		
		Person person1 = new Person(1, "Moreno", 1);
		personList.add(person1);
		
		return personList;
	}
	
	@Override
	public List<Person> getListByUserLogin(String userLogin) {
		List<Person> personList = new ArrayList<>();
		
		Person person1 = new Person(1, "Moreno", 1);
		personList.add(person1);
		
		return personList;
		
	}

	@Override
	public List<PersonUser> getPersonUserListByUserLogin(String login) {
		List<PersonUser> personUserList = new ArrayList<>();
		
		PersonUser personUser1 = new PersonUser("Moreno", "edwaromo");
		personUserList.add(personUser1);
		
		return personUserList;
	}
	
	

}
