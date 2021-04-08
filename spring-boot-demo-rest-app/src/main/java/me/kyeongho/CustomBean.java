package me.kyeongho;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CustomBean {
	
	@Value("${name}")
	private String name;
}
