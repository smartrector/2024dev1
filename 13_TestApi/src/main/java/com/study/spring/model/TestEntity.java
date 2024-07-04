package com.study.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="test")
@Getter
@Setter
//@Builder
public class TestEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	
	
	public TestEntity(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public void changeNameAndAge(String name2, int age2) {
		this.name = name2;
		this.age = age2;
	}
	
	
	
	
}
