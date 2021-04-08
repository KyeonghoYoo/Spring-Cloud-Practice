package me.kyeongho;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "my")
@Data
public class Config {
	
	private List<String> servers = new ArrayList<>();
}
