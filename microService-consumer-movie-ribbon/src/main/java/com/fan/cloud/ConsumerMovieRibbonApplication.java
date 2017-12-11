package com.fan.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author School-PC
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerMovieRibbonApplication {

    @Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
	    return new RestTemplate();
    }

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieRibbonApplication.class, args);
	}
}
