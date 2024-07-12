package com.study.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	@Query("select p,pi from Product p left join p.imageList pi where pi.ord = 0 and p.delFlag = false")
	Page<Object[]> selectList(Pageable pageable);

	@Modifying
	@Query("update Product p set p.delFlag = :flag where p.pno = :pno")
	void updateToDelete(@Param("pno") Long pno,@Param("flag") boolean flag);
	
}
