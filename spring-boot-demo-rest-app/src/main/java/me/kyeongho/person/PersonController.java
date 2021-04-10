package me.kyeongho.person;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@Transactional
@RequestMapping(path = "/person")
@RequiredArgsConstructor
public class PersonController {

	private final PersonRepository personRepository;
	
	@GetMapping
	public List<Person> findAll(){	
		return personRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Person findById(@PathVariable(name = "id") String id) {
		return personRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No Person Found for " + id));
	}
	
	@PostMapping
	public Person add(@RequestBody Person p) {
		Person newPerson = Person.builder()
						.firstName(p.getFirstName())
						.lastName(p.getLastName())
						.age(p.getAge())
						.gender(p.getGender())
						.build();
		
		Person saved = personRepository.save(newPerson);
		
		return saved;
	}
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		personRepository.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Person request) {
		personRepository.save(request);
	}
	
	@GetMapping("/lastname/{lastName}")
	public List<Person> findByLastName(@PathVariable("lastName") String lastName) {
		return personRepository.findByLastName(lastName);
	}
	
	@GetMapping("/age/{age}")
	public List<Person> findByAgeGreaterThan(@PathVariable("age") int age) {
		return personRepository.findByAgeGreaterThan(age);
	}
}
