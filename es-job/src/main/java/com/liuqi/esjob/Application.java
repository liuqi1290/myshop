package com.liuqi.esjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableElasticJob
@SpringBootApplication
@ComponentScan(basePackages = {"com.liuqi.esjob.*","com.liuqi.esjob.service.*","com.liuqi.esjob.task.*"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
