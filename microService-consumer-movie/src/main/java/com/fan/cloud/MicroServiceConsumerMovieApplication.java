package com.fan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author School-PC
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceConsumerMovieApplication {

    @Bean
	public RestTemplate restTemplate(){
	    return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceConsumerMovieApplication.class, args);
	}
}
