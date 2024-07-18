package com.study.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.spring.domain.Cart;
import com.study.spring.domain.CartItem;
import com.study.spring.domain.Member;
import com.study.spring.domain.Product;
import com.study.spring.dto.CartItemDTO;
import com.study.spring.dto.CartItemListDTO;
import com.study.spring.repository.CartItemRepository;
import com.study.spring.repository.CartRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartServiceImpl implements CartService {
	
	private final CartItemRepository cartItemRepository;
	private final CartRepository cartRepository;
	

	@Override
	public List<CartItemListDTO> addOrModify(CartItemDTO cartItemDTO) {
		String email = cartItemDTO.getEmail();
		Long pno =cartItemDTO.getPno();
		int qty = cartItemDTO.getQty();
		Long cino = cartItemDTO.getCino();
		
		if(cino != null) {
			Optional<CartItem> cartItemResult = cartItemRepository.findById(cino);
			
			CartItem cartItem = cartItemResult.orElseThrow();
			
			cartItem.changeQty(qty);
			cartItemRepository.save(cartItem);
			
			return getCartItems(email);
		}
		
		Cart cart = getCart(email);
		
		CartItem cartItem = null;
		
		//이미 동일한 상품이 담긴적있을때
		cartItem = cartItemRepository.getItemOfPno(email, pno);
		
		if(cartItem == null) {
			Product product = Product.builder().pno(pno).build();
			cartItem = CartItem.builder().product(product).cart(cart).qty(qty).build();
		}else {
			cartItem.changeQty(qty);
		}
		
		//상품아이템저장
		cartItemRepository.save(cartItem);
		
		return getCartItems(email);
	}

	private Cart getCart(String email) {
		Cart cart = null;
		Optional<Cart> result = cartRepository.getCartOfMember(email);
		
		if(result.isEmpty()) {
			Member member = Member.builder().email(email).build();
			Cart tempCart = Cart.builder().owner(member).build();
			
			cart =cartRepository.save(tempCart);
		}else {
			cart = result.get();
		}
		
		
		return cart;
	}

	@Override
	public List<CartItemListDTO> getCartItems(String email) {
		
		return cartItemRepository.getItemsOfCartDTOByEmail(email);
	}

	@Override
	public List<CartItemListDTO> remove(Long cino) {
		Long cno = cartItemRepository.getCartFromItem(cino);
		
		cartItemRepository.deleteById(cino);
		
		return cartItemRepository.getItemsOfCartDTOByCart(cno);
	}

}
