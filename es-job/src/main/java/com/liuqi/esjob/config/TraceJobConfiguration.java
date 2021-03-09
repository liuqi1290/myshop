package com.liuqi.esjob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.liuqi.esjob.annotation.JobTraceInterceptor;

//@Configuration
public class TraceJobConfiguration {

	@Bean
	public JobTraceInterceptor jobTraceInterceptor() {
		System.err.println("init --------------->");
		return new JobTraceInterceptor();
	}
	
}
