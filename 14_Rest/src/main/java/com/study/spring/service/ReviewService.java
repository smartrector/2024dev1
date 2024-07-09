package com.study.spring.service;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.study.spring.model.ReviewEntity;
import com.study.spring.repository.RestaurantRepository;
import com.study.spring.repository.ReviewRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {
	
	private final RestaurantRepository restaurantRepository;
	private final ReviewRepository reviewRepository;
	
	@Transactional
	public void createReview(Long restaurantId, String content, Double score) {
		
		restaurantRepository.findById(restaurantId).orElseThrow();
		
//		ReviewEntity review = new ReviewEntity();
		ReviewEntity review = ReviewEntity.builder()
				.restaurantId(restaurantId)
				.content(content)
				.score(score)
				.createdAt(ZonedDateTime.now())
				.build();
		
		
		reviewRepository.save(review);
	}
	
	public void deleteReview(Long reviewId) {
		ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();
		reviewRepository.delete(review);
	}
}
