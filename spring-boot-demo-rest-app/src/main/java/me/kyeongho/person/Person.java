package me.kyeongho.person;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Builder
public class Person {

	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private Gender gender;
	
	@Getter
	@Setter
	@RequiredArgsConstructor
	public class Gender {
		
		private String value;
	}
}
