package com.study.spring.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.api.request.CreateReviewRequest;
import com.study.spring.service.ReviewService;

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
}
