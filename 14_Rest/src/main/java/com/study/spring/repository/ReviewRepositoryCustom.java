package com.study.spring.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.study.spring.model.ReviewEntity;

public interface ReviewRepositoryCustom {
	Double getAvgScoreByRestaurantId(Long restaurantId);
	Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId,Pageable page);
}
