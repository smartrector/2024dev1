package com.study.spring.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.api.request.CreateAndEditRestaurantRequest;
import com.study.spring.api.response.RestaurantDetailView;
import com.study.spring.api.response.RestaurantView;
import com.study.spring.model.RestaurantEntity;
import com.study.spring.service.RestaurantSevice;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class RestaurantApi {
	
	
	private final RestaurantSevice restaurantSevice;
	
	@CrossOrigin
	@GetMapping("/restaurants")
	public List<RestaurantView> getRestaurants() {
//		return "getRestaurants";
		return restaurantSevice.getAllRestaurants();
	}
	
	
	@GetMapping("/restaurant/{restaurantId}")
	public RestaurantDetailView getRestaurant(
			@PathVariable("restaurantId") Long restaurantId
			) {
//		return "getRestaurant id : "+ restaurantId;
		return restaurantSevice.getRestaurantDetails(restaurantId);
	}
	
//	#first
	@PostMapping("/restaurant")
	public RestaurantEntity createRestaurant(
			@RequestBody CreateAndEditRestaurantRequest request
			) {
//		return "createRestaurant name : " + request.getName() 
//				+ ", address : " + request.getAddress() 
//				+ ", menu[0].name : " + request.getMenus().get(0).getName()
//				+ ", menu[1].name : " + request.getMenus().get(1).getName();
		
		return restaurantSevice.createRestaurant(request);
				
	}
	@PutMapping("/restaurant/{restaurantId}")
	public void editRestaurant(
			@PathVariable("restaurantId") Long restaurantId,
			@RequestBody CreateAndEditRestaurantRequest request
			) {
		
//		return "editRestaurant id : " + restaurantId + ", name : " + request.getName() 
//		+ ", address : " + request.getAddress() 
//		+ ", menu[0].name : " + request.getMenus().get(0).getName()
//		+ ", menu[1].name : " + request.getMenus().get(1).getName();
		
		restaurantSevice.editRestaurant(restaurantId, request);
	}
	
	@DeleteMapping("/restaurant/{restaurantId}")
	public void deleteRestaurant(
			@PathVariable("restaurantId") Long restaurantId
			) {
//		return "delete restaurant id :"+ restaurantId;
		restaurantSevice.deleteRestaurant(restaurantId);
	}
}
