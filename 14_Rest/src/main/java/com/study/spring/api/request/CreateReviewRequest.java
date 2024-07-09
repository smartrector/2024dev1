package com.study.spring.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateReviewRequest {
	private Long restaurantId;
	private String content;
	private Double score;
}
