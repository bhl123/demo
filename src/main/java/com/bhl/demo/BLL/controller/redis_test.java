package com.bhl.demo.BLL.controller;

import com.bhl.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class redis_test {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void set(){
        System.out.println("啦啦啦啦啦啦");
//        redisTemplate.opsForValue().set("myKey","myValue");
//        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }
}
