package com.fan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author School-PC
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerMovieFeignApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieFeignApplication.class, args);
	}
}
