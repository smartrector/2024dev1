package com.study.spring.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.api.request.CreateReviewRequest;
import com.study.spring.service.ReviewService;
import com.study.spring.service.dto.ReviewDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReviewApi {
	private final ReviewService reviewService;
	
	@PostMapping("/review")
	public void createReview(
			@RequestBody CreateReviewRequest request
			) {
		reviewService.createReview(request.getRestaurantId(), request.getContent(), request.getScore());
	}
	
	@DeleteMapping("/review/{reviewId}")
	public void deleteReview(
			@PathVariable("reviewId") Long reviewId
			) {
		reviewService.deleteReview(reviewId);
	}
	
	 @GetMapping("/restaurant/{restaurantId}/reviews")
	    public ReviewDto getRestaurantReviews(
	            @PathVariable("restaurantId") Long restaurantId,
	            @RequestParam("offset") Integer offset,
	            @RequestParam("limit") Integer limit
	    ){
	        return reviewService.getRestaurantReview(restaurantId, PageRequest.of( offset / limit, limit));
	    }
}
