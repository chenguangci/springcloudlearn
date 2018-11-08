package com.beiy.mqTest;

import com.beiyi.BusApplication;
import com.beiyi.mq.Sender;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusApplication.class)
public class RabbitMqTest {

    @Autowired
    private Sender sender;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        sender.send();
//        redisTemplate.opsForSet().add("time", "1");
//        System.out.println(redisTemplate.opsForValue().get("times"));
    }

}
