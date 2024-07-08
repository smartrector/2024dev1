package com.study.spring.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.spring.api.request.CreateAndEditRestaurantRequest;
import com.study.spring.model.MenuEntity;
import com.study.spring.model.RestaurantEntity;
import com.study.spring.repository.MenuRepository;
import com.study.spring.repository.RestaurantRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RestaurantSevice {
	
	private final RestaurantRepository restaurantRepository;
	private final MenuRepository menuRepository;
	
	@Transactional
	public RestaurantEntity createRestaurant(
			CreateAndEditRestaurantRequest request
			) {
//		 RestaurantEntity restaurant = new RestaurantEntity(request.getName(),...);
		 RestaurantEntity restaurant = RestaurantEntity.builder()
				 .name(request.getName())
				 .address(request.getAddress())
				 .createdAt(ZonedDateTime.now())
				 .updatedAt(ZonedDateTime.now())
				 .build();
		 
		 restaurantRepository.save(restaurant);
		 request.getMenus().forEach((menu)->{
//			 MenuEntity menuEntity = new MenuEntity(test,test,test,.menu.menu.);
			 MenuEntity menuEntity = MenuEntity.builder()
					 .restaurantId(restaurant.getId())
					 .name(menu.getName())
					 .price(menu.getPrice())
					 .createdAt(ZonedDateTime.now())
					 .updatedAt(ZonedDateTime.now())
					 .build();
			 
			 menuRepository.save(menuEntity);
			 
		 });
		return restaurant;
	}
	
	@Transactional
	public void editRestaurant(
			Long restaurantId,
			CreateAndEditRestaurantRequest request
			) {
		RestaurantEntity restaurant = restaurantRepository	.findById(restaurantId)
															.orElseThrow(()->new RuntimeException("아이디가 없음"));
		restaurant.changeNameAndAddress(request.getName(),request.getAddress());
		restaurantRepository.save(restaurant);
		
		//이전메뉴 삭제
		List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
		menuRepository.deleteAll(menus);
		
		// 새로운메뉴 생성
		request.getMenus().forEach((menu)->{
			MenuEntity menuEntity = MenuEntity.builder()
					.restaurantId(restaurantId)
					.name(menu.getName())
					.price(menu.getPrice())
					.createdAt(ZonedDateTime.now())
					.updatedAt(ZonedDateTime.now())
					.build();
			menuRepository.save(menuEntity);
		});
		
	}
}
