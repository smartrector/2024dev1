package com.study.spring.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
	
	@GetMapping("/hello/world")
	public String getHello() {
		return "get hellow world";
	}
	
	@PostMapping("/hello/world")
	public String postHello() {
		return "post hellow world";
	}
	
	@PutMapping("/hello/world")
	public String putHello() {
		return "put hellow world";
	}
	
	@DeleteMapping("/hello/world")
	public String deleteHello() {
		return "delete hellow world";
	}
}
