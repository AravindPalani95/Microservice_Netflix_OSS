package com.sb.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class EInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EInventoryServiceApplication.class, args);
	}

}
