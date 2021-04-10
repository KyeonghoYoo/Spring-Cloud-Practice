package me.kyeongho.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "person")
@Getter
@Builder
public class Person {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	private Gender gender;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
