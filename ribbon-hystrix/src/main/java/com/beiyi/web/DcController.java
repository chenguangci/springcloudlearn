package com.beiyi.web;

import com.beiyi.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    private ConsumerService service;

    @GetMapping("/consumer")
    public String db() {
        return service.consumer();
    }
}
