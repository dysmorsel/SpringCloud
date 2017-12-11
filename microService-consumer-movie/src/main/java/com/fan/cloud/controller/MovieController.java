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

    private String userServicePath;

    private final RestTemplate restTemplate;

    @Autowired
    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${user.userServicePath}")
    public void setUserServicePath(String userServicePath){
        this.userServicePath = userServicePath;
    }

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject(userServicePath +id,User.class);
    }
}
