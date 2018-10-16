package com.feign.bean;

import net.beiyi.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("beiyi-client")
public interface DcClient {

    /**
     * feign以一种类似调用本地方法的方式调用远程方法，
     * 相比于ribbon使用更加方便一些
     * @return
     */
    @GetMapping("/hello")
    String consumer();

    /**
     * 参数传递比较规范
     * @param name 名字
     * @return user实体
     */
    @GetMapping("/userBean")
    User user(@RequestParam(value = "name", required = false)String name);
}
