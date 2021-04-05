package me.kyeongho;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private final ApplicationConfiguration applicationProperties;
	
	public WelcomeController(ApplicationConfiguration applicationProperties) {
		this.applicationProperties = applicationProperties;
	}
	
	@GetMapping(path = "/welcome")
	public Map<String, String> welcome() {
		
		final Map<String, String> map = new HashMap<>();
		map.put("message", applicationProperties.getMessage());
		
		return map;
	}
}
