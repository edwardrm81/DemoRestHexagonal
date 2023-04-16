package com.edw.demo.infra.inputadapter_entrypoint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edw.demo.domain.entity.Person;
import com.edw.demo.infra.inputport.IPersonServiceInputPort;

@RestController
@RequestMapping("/person")
public class RestPersonController {

	@Autowired
	private IPersonServiceInputPort personService;
	
	@GetMapping("")
	public ResponseEntity<?> personListAll() throws Throwable {
		return ResponseEntity.ok(personService.getPersonListAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> personById(@PathVariable("id") Integer id) throws Throwable {
			return ResponseEntity.ok(personService.getPersonById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> insertPerson(@RequestBody Person person) throws Throwable {
			return ResponseEntity.ok(personService.insertPerson(person));
	}
	
	@PutMapping
	public ResponseEntity<?> updatePerson(@RequestBody Person person) throws Throwable {
			return ResponseEntity.ok(personService.updatePerson(person));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePersonById(@PathVariable("id") Integer id) throws Throwable {
			personService.deletePersonById(id);
			return ResponseEntity.ok(null);	
	}
	
	@GetMapping("/id/{id}/name/{name}")
	public ResponseEntity<?> personListByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) throws Throwable {
		return ResponseEntity.ok(personService.getPersonByIdAndName(id, name));	
	}
	
	@GetMapping("/id2/{id}/name/{name}")
	public ResponseEntity<?> getListByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) throws Throwable {
		return ResponseEntity.ok(personService.getListByIdAndName(id, name));	
	}
	
	@GetMapping("/login/{login}")
	public ResponseEntity<?> getListByUserLogin(@PathVariable("login") String login) throws Throwable {
		return ResponseEntity.ok(personService.getListByUserLogin(login));	
	}
}
