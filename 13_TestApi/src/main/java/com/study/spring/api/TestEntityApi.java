package com.study.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.service.TestService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TestEntityApi {
	
	private final TestService testService;
	
	@GetMapping("/test/entity/create")
	public void  createTestEntity() {
		 testService.create("hanyong5", 100);
	}
}
