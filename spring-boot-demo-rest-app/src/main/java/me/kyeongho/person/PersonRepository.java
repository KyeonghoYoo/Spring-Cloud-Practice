package me.kyeongho.person;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String>{
	
	public List<Person> findByLastName(String lastName);
	public List<Person> findByAgeGreaterThan(int age);
}
