package com.beiyi.web;

import net.beiyi.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    private LoadBalancerClient client;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    @ResponseBody
    public User dc(@RequestParam("name")String name) {
        /*
         * 通过指定服务提供方的名字，调用指定的api
         */
        ServiceInstance serviceInstance = client.choose("beiyi-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/userBean?name=" + name;
        System.out.println(url);
        return restTemplate.getForObject(url, User.class);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("token")String token) {
        ServiceInstance serviceInstance = client.choose("api-gateway");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/api-a/hello?token=" + token;
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
