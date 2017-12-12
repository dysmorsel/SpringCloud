package com.fan.cloud.controller;

import com.fan.cloud.feign.UserFeignClient;
import com.fan.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author School-PC
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient feignClient;


    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return feignClient.findById(id);
    }
}
