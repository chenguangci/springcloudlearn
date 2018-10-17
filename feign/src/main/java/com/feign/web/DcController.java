package com.feign.web;

import com.feign.bean.DcClient;
import net.beiyi.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
        String str = dcClient.consumer("ok");
        System.out.println(str);
        return str;
    }

    @GetMapping("/getUser")
    @ResponseBody
    public User getUser(@RequestParam(value = "name", required = false)String name) {
        return dcClient.user(name);
    }

}
