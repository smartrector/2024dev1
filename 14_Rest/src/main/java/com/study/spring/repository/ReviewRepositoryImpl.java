package com.study.spring.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.spring.model.QReviewEntity;
import com.study.spring.model.ReviewEntity;
//import com.study.spring.model.QReviewEntity;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
	
	private JPAQueryFactory queryFactory;

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
                //reviewEntity 테이블에서 조회
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                //페이지의 시작위치
                .offset((long) page.getPageNumber() * page.getPageSize())
                //요청한 페이지 크기보다 1개 더 가져옴
                .limit(page.getPageSize() +1 )
                .fetch();

        //Slice 인터페이스의 구현체 생성
        return new SliceImpl<>(
                //실제 페이지크기만큼의 리뷰만 포함
                reviews.stream().limit(page.getPageSize()).toList(),
                //현제페이지정보
                page,
                //다음페이지존제여부 크면 True
                reviews.size() > page.getPageSize()

        );
	}

}
