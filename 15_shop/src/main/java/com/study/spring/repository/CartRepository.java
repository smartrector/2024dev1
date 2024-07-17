package com.study.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.spring.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query("select cart from Cart cart where cart.owner.email = :email ")
	Optional<Cart> getCartOfMember(@Param("email") String email);
}
