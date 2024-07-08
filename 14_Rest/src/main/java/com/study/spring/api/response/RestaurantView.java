package com.study.spring.api.response;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantView {
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
}
