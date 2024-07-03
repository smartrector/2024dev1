package com.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.model.TestEntity;
import com.study.spring.repository.TestRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TestService {
		
	private final TestRepository testRepository;
	
	public TestEntity create(String name, int age) {
		TestEntity testEntity = new TestEntity(name, age);
		testRepository.save(testEntity);
		return testEntity;
		
	}
}
