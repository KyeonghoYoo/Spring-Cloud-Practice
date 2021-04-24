package me.kyeongho;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping(path = "/ping")
	public List<ServiceInstance> ping() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLIENT_SERVICE");
		
		logger.info("INSTANCES: count={}", instances.size());
		instances.stream().forEach(it -> logger.info("INSTANCE: id{}, port={}", it.getServiceId(), it.getPort()));
		
		return instances;
	}
}
