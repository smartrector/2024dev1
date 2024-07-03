package com.study.spring.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.service.TestService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
public class TestEntityApi {
	
	private final TestService testService;
	
	@PostMapping("/test/entity/create")
	public ResponseEntity<String> createTestEntity(
			@RequestBody CreateTestEntityRequest request
			) {
		 
		testService.create(request.getName(),request.getAge());
		
		return new ResponseEntity<>("{\"ok\"}",HttpStatus.CREATED);
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateTestEntityRequest{
		private String name;
		private int age;
	}
	
}
