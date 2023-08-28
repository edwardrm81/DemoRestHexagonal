package com.edw.demo.infra.inputadapter_entrypoint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.infra.inputadapter_entrypoint.preusecase.interfaces.IPersonFacade;

@RestController
@RequestMapping("/person")
public class RestPersonController {

	@Autowired
	private IPersonFacade personFacade;
	
	@GetMapping("")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ResponseEntity<?> personListAll() throws Throwable {
		return ResponseEntity.ok(personFacade.personListAll());	
	}
	
	@GetMapping("/{id}")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ResponseEntity<?> personById(@PathVariable("id") Integer id) throws Throwable {
			return ResponseEntity.ok(personFacade.getPersonById(id));
	}
	
	@PostMapping
	@Transactional(propagation = Propagation.REQUIRED)
	public ResponseEntity<?> insertPerson(@RequestBody Person person) throws Throwable {
			return ResponseEntity.ok(personFacade.insertPerson(person));
	}
	
	@PutMapping
	@Transactional(propagation = Propagation.REQUIRED)
	public ResponseEntity<?> updatePerson(@RequestBody Person person) throws Throwable {
			return ResponseEntity.ok(personFacade.updatePerson(person));
	}
	
	@DeleteMapping("/{id}")
	@Transactional(propagation = Propagation.REQUIRED)
	public ResponseEntity<?> deletePersonById(@PathVariable("id") Integer id) throws Throwable {
			personFacade.deletePersonById(id);
			return ResponseEntity.ok(null);	
	}
	
	@GetMapping("/id/{id}/name/{name}")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ResponseEntity<?> personListByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) throws Throwable {
		return ResponseEntity.ok(personFacade.getPersonByIdAndName(id, name));	
	}
	
	@GetMapping("/id2/{id}/name/{name}")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ResponseEntity<?> getListByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) throws Throwable {
		return ResponseEntity.ok(personFacade.getListByIdAndName(id, name));	
	}
	
	@GetMapping("/login/{login}")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ResponseEntity<?> getListByUserLogin(@PathVariable("login") String login) throws Throwable {
		return ResponseEntity.ok(personFacade.getListByUserLogin(login));	
	}
	
	@GetMapping("/personuser/login/{login}")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ResponseEntity<?> getPersonUserListByUserLogin(@PathVariable("login") String login) throws Throwable {
		return ResponseEntity.ok(personFacade.getPersonUserListByUserLogin(login));
	}
}
