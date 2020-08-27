package com.liuqi.test;

import com.liuqi.Application;
import com.liuqi.ApplicationTest;
import com.liuqi.testService.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
@WebAppConfiguration
public class transTest {
   @Autowired
   private TestTransService testTransService;

    @Test
    public  void mytest(){

        testTransService.testTransService();
    }
}
