package com.fan.cloud.controller;

import com.fan.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author School-PC
 */
@RestController
public class MovieController {


    private final RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        this.loadBalancerClient.choose("microservice-provider-user");
        //使用占位符的方式
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/{1}",User.class,id);
    }
}
