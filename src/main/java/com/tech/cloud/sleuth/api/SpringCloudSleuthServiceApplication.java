package com.tech.cloud.sleuth.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringCloudSleuthServiceApplication {

	@Autowired
	RestTemplate template;
	
	Logger log = LoggerFactory.getLogger(SpringCloudSleuthServiceApplication.class);
	
	@GetMapping("/getDiscount")
	public String discount() {
		log.info("Discount service is called");
		return "added discount 25%";
	}
	
	@GetMapping("/payment")
	public String payment() {
		log.info("Payment service is called");
		String url = "http://localhost:8081/getDiscount";
		return template.getForObject(url, String.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSleuthServiceApplication.class, args);
	}

}
