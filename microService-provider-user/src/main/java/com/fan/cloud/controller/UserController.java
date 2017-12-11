package com.fan.cloud.controller;

import com.fan.cloud.dao.dao.UserRepository;
import com.fan.cloud.entity.User;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author School-PC
 */
@RestController
public class UserController {

    private final EurekaClient eurekaClient;

    private final UserRepository userRepository;

    private final DiscoveryClient discoveryClient;

    @Autowired
    public UserController(UserRepository userRepository, @Qualifier("eurekaClient") EurekaClient eurekaClient,@Qualifier("discoveryClient") DiscoveryClient discoveryClient) {
        this.userRepository = userRepository;
        this.eurekaClient = eurekaClient;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return this.userRepository.findOne(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER",false);
        return instance.getHomePageUrl();
    }

    @GetMapping("instance-info")
    public ServiceInstance showInfo(){
        return this.discoveryClient.getLocalServiceInstance();
    }
}
