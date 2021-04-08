package me.kyeongho.person;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {

	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private Gender gender;
}
