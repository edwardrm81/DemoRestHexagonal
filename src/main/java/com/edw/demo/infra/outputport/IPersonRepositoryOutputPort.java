package com.edw.demo.infra.outputport;

import java.util.List;

import com.edw.demo.domain.entity.Person;
 
public interface IPersonRepositoryOutputPort extends GenericRepositoryOutputPort<Person, Integer>{

	public List<Person> findByIdAndName(Integer id, String name);
	public List<Person> getListByIdAndName(Integer id, String name);
	public List<Person> getListByUserLogin(String login);
}
