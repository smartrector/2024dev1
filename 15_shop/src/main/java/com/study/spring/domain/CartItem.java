package com.study.spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString(exclude={"cart","product"})
@Table(
		name="tbl_cart_item",
		indexes= {
				@Index(name="idx_cartitem_cart", columnList="cart_cno"),
				@Index(name="idx_cartitem_pno_cart", columnList="product_pno, cart_cno")
		}
		)
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cino;
	
	private int qty;
	
	@ManyToOne
	@JoinColumn(name="cart_cno")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="product_pno")
	private Product product;
	
	
	public void changeQty(int qty) {
		this.qty = qty;
	}
	
	
}
