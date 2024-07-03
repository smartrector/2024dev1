package com.study.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestRequestApi {
	
	//param
	@GetMapping("/test/param")  // test/param?name=hong&age=50
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") int age
			) {
		return "requestParam name : " + name + "/" + age;
	}
	
	//path variable
	@GetMapping("/test/path/{name}/{age}")
	public String requestPath(
			@PathVariable("name") String name,
			@PathVariable("age") int age
			) {
		return "requestPath name : " + name + "/" + age;
	}
	
	//request body
//	@PostMapping("/test/body")
//	public String requestBody(
//			@RequestBody TestRequestBody request
//			) {
//		return "requestBody name : " + request.name + "/" + request.age;
//	}
//	
//	
//	@Data
//	public static class TestRequestBody{
//		String name;
//		int age;
//		
//		public TestRequestBody() {
//			
//		}
//		
//		public TestRequestBody(String name, int age) {
//			this.name = name;
//			this.age = age;
//		}
//		
//	}
	
	
	@PostMapping("/test/body")
	public String requestBody(
			@RequestBody TestRequestDto request
			) {
		return "requestBody name : " + request.name + "/" + request.age;
	}
	
}
