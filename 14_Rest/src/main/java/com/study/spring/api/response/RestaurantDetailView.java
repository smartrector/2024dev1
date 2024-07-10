package com.study.spring.api.response;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDetailView {
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	private List<Menu> menus;
	
	@Builder
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Menu{
		private Long id;
		private String name;
		private Integer price;
		private ZonedDateTime createdAt;
		private ZonedDateTime updatedAt;
		
	}
}
