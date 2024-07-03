package com.study.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.api.response.TestResponseBody;

import lombok.Data;

@RestController
public class TestResponseApi {
	
	@GetMapping("/test/response/string")
	public String response() {
		return "hello world";
	}
	
//	@GetMapping("/test/response/json")
//	public String jsonResponse() {
//		return "{\"message\":\"hello\"}";
//	}
	
	@GetMapping("/test/response/json")
	public TestResponseBody jsonResonse() {
		
//		TestResponseBody response = new TestResponseBody("hanyong5",100);
//		return response;
		
		return new TestResponseBody("hanyong5",100);
	}
	
	
//	@Data
//	public static class TestResponseBody{
//		String name;
//		int age;
//		public TestResponseBody(String name, int age) {
//			this.name = name;
//			this.age = age;
//		}
//		
//	}
	
	
}
