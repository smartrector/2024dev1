package com.study.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.spring.domain.CartItem;
import com.study.spring.dto.CartItemListDTO;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	
	/*
	1. 사용자의 이메일을 통해서 모든 장바구니 데이터 조회
	 
	 */
	
	@Query("select "
			+ " new com.study.spring.dto.CartItemListDTO(ci.cino, p.pno, p.pname, ci.qty, p.price, pi.fileName) "
			+ "from "
			+ " CartItem ci inner join Cart mc on ci.cart = mc "
			+ " left join Product p on ci.product = p "
			+ " left join p.imageList pi "
			+ "where "
			+ " mc.owner.email = :email and pi.ord = 0 order by ci.cino desc")
	List<CartItemListDTO> getItemsOfCartDTOByEmail(@Param("email") String email);
	
		
	
		@Query("select ci from CartItem ci left join Cart c on ci.cart = c " +
	            "where " +
	            " c.owner.email = :email and ci.product.pno = :pno")
	    CartItem getItemOfPno(@Param("email") String email, @Param("pno") Long pno);

	    @Query("select c.cno from Cart c left join CartItem ci on ci.cart = c where ci.cino = :cino")
	    Long getCartFromItem(@Param("cino") Long cino);

//	    @Query("select " +
//	            " new com.spring.dto.CartItemListDTO(ci.cino, ci.qty,p.pno, p.pname, p.price, pi.fileName) " +
//	            "from " +
//	            " CartItem ci inner join Cart mc on ci.cart = mc " +
//	            " left join Product p on ci.product = p " +
//	            " left join p.imageList pi " +
//	            "where " +
//	            " mc.cno = :cno and pi.ord = 0 " +
//	            " order by ci.cino desc")
//	    List<CartItemListDTO> getItemsOfCartDTOByCart(@Param("cno") Long cno);
}
