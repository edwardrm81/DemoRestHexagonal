package com.edw.demo.infra.outputport;

import java.util.List;

public interface GenericRepositoryOutputPort<T, ID> {

	public List<T> findAll();
	public T findById(ID id);
	public T create(T t);
	public T update(T t);
	public void deleteById(ID id);
	
}
