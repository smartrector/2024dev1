package com.study.spring.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.spring.model.QReviewEntity;
import com.study.spring.model.ReviewEntity;



import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
	
	private final JPAQueryFactory queryFactory;

	@Override
	public Double getAvgScoreByRestaurantId(Long restaurantId) {
		return queryFactory.select(QReviewEntity.reviewEntity.score.avg())
				.from(QReviewEntity.reviewEntity)
				.where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
				.fetchFirst();
	}

	@Override
	public Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable page) {
		List<ReviewEntity> reviews = queryFactory.select(QReviewEntity.reviewEntity)
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                .offset((long) page.getPageNumber() * page.getPageSize())
                .limit(page.getPageSize() +1 )
                .fetch();

        return new SliceImpl<>(
                reviews.stream().limit(page.getPageSize()).toList(),
                page,
                reviews.size() > page.getPageSize()

        );
	}

}
