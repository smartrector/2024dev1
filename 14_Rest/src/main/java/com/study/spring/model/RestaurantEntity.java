package com.study.spring.model;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="restaurant")
@Getter
public class RestaurantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	public void changeNameAndAddress(String name, String address) {
		this.name = name;
		this.address = address;
		this.updatedAt = ZonedDateTime.now();
	}
	
}
