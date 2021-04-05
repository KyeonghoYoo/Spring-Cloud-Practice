package me.kyeongho;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${application.message}")
	private String message;
	
	@GetMapping(path = "/test")
	public Map<String, String> test() {
		
		final Map<String, String> map = new HashMap<>();
		map.put("message", message);
		
		return map;
	}
}
