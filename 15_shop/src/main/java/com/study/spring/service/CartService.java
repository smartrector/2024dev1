package com.study.spring.service;

import java.util.List;

import com.study.spring.dto.CartItemDTO;
import com.study.spring.dto.CartItemListDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface CartService {
	
	//장바구니 아이템 추가 변경
	public List<CartItemListDTO> addOrModify(CartItemDTO cartItemDTO);
	
	// 모든 장바구니 아이템 목록
	public List<CartItemListDTO> getCartItems(String email);
	
	//아이템삭제
	public List<CartItemListDTO> remove(Long cino);
}
