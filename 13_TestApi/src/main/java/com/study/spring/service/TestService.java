package com.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.model.TestEntity;
import com.study.spring.repository.TestRepository;

import jakarta.persistence.EntityNotFoundException;
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

	public void delete(Long id) {
		TestEntity testEntity = testRepository.findById(id).get();
		testRepository.delete(testEntity);
	}

	public void update(Long id, String name, int age) {
		TestEntity testEntity = 
				testRepository.findById(id)
								.orElseThrow(()-> 
								new EntityNotFoundException("아이디없음"));
		testEntity.changeNameAndAge(name, age);
		testRepository.save(testEntity);
	}
}
