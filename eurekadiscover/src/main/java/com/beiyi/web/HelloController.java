package com.beiyi.web;

import net.beiyi.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    //注入DiscoveryClient对象
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
//        Thread.sleep(5000L);
        String services = "Services: " + discoveryClient.getServices();
        logger.info("services:" + services);
        return services;
    }

    @GetMapping(value = "/userBean")
    @ResponseBody
    public User user(@RequestParam(value = "name", required = false, defaultValue = "unKnown") String name) {
        return new User(1001L, name, 23, "coding");
    }

}
