package com.study.spring.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.dto.CartItemDTO;
import com.study.spring.dto.CartItemListDTO;
import com.study.spring.service.CartService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/cart")
public class CartController {
	private final CartService cartService;
	
	@PreAuthorize("#itemDTO.email == authentication.name")
	@PostMapping("/change")
	public List<CartItemListDTO> changeCart(@RequestBody CartItemDTO itemDTO){
		if(itemDTO.getQty()<=0) {
			return cartService.remove(itemDTO.getCino());
		}
		return cartService.addOrModify(itemDTO);
	}
	
	
	@GetMapping("/items")
	public List<CartItemListDTO> getCartItems(Principal principal){
		
		String email = principal.getName();
		log.info("email : " + email);

		return cartService.getCartItems(email);
	}
	
	@DeleteMapping("/{cino}")
	public List<CartItemListDTO> removeFromCart(@PathVariable("cino") Long cino){
		return cartService.remove(cino);
	}
	
}
