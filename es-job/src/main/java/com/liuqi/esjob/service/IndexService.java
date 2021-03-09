package com.liuqi.esjob.service;

import org.springframework.stereotype.Service;

import com.liuqi.esjob.annotation.JobTrace;

@Service
public class IndexService {

	@JobTrace
	public void tester(String name) {
		System.err.println("name: " + name);
	}
}
