package com.fan.cloud.controller;

import com.fan.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" +id,User.class);
    }
}
