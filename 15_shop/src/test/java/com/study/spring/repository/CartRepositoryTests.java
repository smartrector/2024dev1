package com.study.spring.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.study.spring.domain.Cart;
import com.study.spring.domain.CartItem;
import com.study.spring.domain.Member;
import com.study.spring.domain.Product;
import com.study.spring.dto.CartItemListDTO;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class CartRepositoryTests {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Test
	public void testListOfMember() {
		String email = "user1@aaa.com";
		List<CartItemListDTO> cartItemList = cartItemRepository.getItemsOfCartDTOByEmail(email);
		for(CartItemListDTO dto:cartItemList) {
			System.out.println(dto);
		}
		
		
	}
	
//	@Transactional
//	@Commit
//	@Test
//	public void testInsertByProduct() {
//		String email = "user1@aaa.com";
//		Long pno = 4L;
//		int qty=10;
//		
//		//이메일 cart_item에 자료확인
//		CartItem cartItem = cartItemRepository.getItemOfPno(email, pno);
//		
//		if(cartItem != null) {
//			cartItem.changeQty(qty);
//			cartItemRepository.save(cartItem);
//			return;
//		}
//		
//		Optional<Cart> result = cartRepository.getCartOfMember(email);
//		
//		Cart cart = null;
//		
//		if(result.isEmpty()) {
//			Member member = Member.builder().email(email).build();
//			Cart tempCart = Cart.builder().owner(member).build();
//			
//			cart =cartRepository.save(tempCart);
//		}else {
//			cart = result.get();
//		}
//		Product product = Product.builder().pno(pno).build();
//		cartItem = CartItem.builder()
//				.cart(cart).qty(qty).product(product)
//				.build();
//		
//		cartItemRepository.save(cartItem);
//		
//	}
	
	
}
