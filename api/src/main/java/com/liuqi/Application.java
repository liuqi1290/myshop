package com.liuqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;
@ComponentScan(basePackages ={"com.liuqi","com.org.n3r.idworker"})
@SpringBootApplication
@MapperScan(basePackages = "com.liuqi.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
