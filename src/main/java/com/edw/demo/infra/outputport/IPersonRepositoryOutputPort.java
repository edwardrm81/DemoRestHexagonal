package com.edw.demo.infra.outputport;

import java.util.List;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.domain.entity.PersonUser;
 
public interface IPersonRepositoryOutputPort extends GenericRepositoryOutputPort<Person, Integer>{

	public List<Person> findByIdAndName(Integer id, String name);
	public List<Person> getListByIdAndName(Integer id, String name);
	public List<Person> getListByUserLogin(String login);
	public List<PersonUser> getPersonUserListByUserLogin(String login);
}
