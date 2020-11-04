package com.liuqi.rabbitmqproducer;

import com.liuqi.rabbitmqproducer.componet.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class producerTest {
    @Autowired
    private RabbitSender rabbitSender;
    @Test
    public void sendtest()throws Exception{
        HashMap<String, Object> map = new HashMap<>();
        map.put("123", "cccc");
        map.put("abc", "1111");
        rabbitSender.send("exchange-1", "springboot-rabbit", "ceshi",map );
        Thread.sleep(10000);
    }
}
