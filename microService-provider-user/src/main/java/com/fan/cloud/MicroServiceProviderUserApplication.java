package com.fan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author School-PC
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProviderUserApplication.class, args);
	}
}
