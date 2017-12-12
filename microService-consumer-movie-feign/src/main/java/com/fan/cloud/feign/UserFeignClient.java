package com.fan.cloud.feign;

import com.fan.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author School-PC
 */
@FeignClient("microservice-provider-user")
public interface UserFeignClient {

    /**
     * 两个注意事项：
     * 1、GetMapping不支持
     * 2、@PathVariable必须设置value
     * @param id
     * @return
     */
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

}
