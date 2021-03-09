package com.liuqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@ComponentScan(basePackages ={"com.liuqi","com.org.n3r.idworker"})
@MapperScan(basePackages = "com.liuqi.mapper")
@SpringBootApplication
public class FDFSApplication {
    public static void main(String[] args) {
        SpringApplication.run(FDFSApplication.class,args);
    }

}

