package me.kyeongho.person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

	private List<Person> persons = new ArrayList<>();
	
	@GetMapping
	public List<Person> findAll(){
		
		return persons;
	}
	
	@GetMapping(path = "/{id}")
	public Person findById(@PathVariable(name = "id") Long id) {
		
		return persons.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No Person Found for " + id));
	}
	
	@PostMapping
	public Person add(@RequestBody Person p) {
		Person newPerson = Person.builder()
						.id(Long.valueOf(persons.size() + 1))
						.firstName(p.getFirstName())
						.lastName(p.getLastName())
						.age(p.getAge())
						.gender(p.getGender())
						.build();
		
		persons.add(newPerson);
		
		return newPerson;
	}
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		List<Person> results = persons.stream()
			.filter(p -> p.getId().equals(id))
			.collect(Collectors.toList());
		
		persons.removeAll(results);
	}
	
	@PutMapping
	public void update(@RequestBody Person request) {
		Person person = persons.stream()
			.filter(p -> p.getId().equals(request.getId()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("No Person Found for " + request.getId()));
		persons.set(persons.indexOf(person), Person.builder()
										.id(person.getId())
										.firstName(request.getFirstName() != null ? request.getFirstName() : person.getFirstName())
										.lastName(request.getLastName() != null ? request.getLastName() : person.getLastName())
										.age(request.getAge() > 0 ? request.getAge() : person.getAge())
										.gender(request.getGender() != null ? request.getGender() : person.getGender())
										.build());
	}
}
