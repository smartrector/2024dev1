package com.study.spring.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class CartItemListDTO {
	private Long cino;
	private Long pno;
	private String pname;
	private int qty;
	private int price;
	private String imageFile;
	
	//repository projection 생성을 위한 생성자
	public CartItemListDTO(Long cino, Long pno, String pname, int qty, int price, String imageFile) {
		this.cino = cino;
		this.pno = pno;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.imageFile = imageFile;
	}
	
	
	
	
}
