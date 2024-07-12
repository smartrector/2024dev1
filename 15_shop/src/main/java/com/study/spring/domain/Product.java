package com.study.spring.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tbl_product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="imageList")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pno;
	private String pname;
	private int price;
	private String pdesc;
	private boolean delFlag; //false->true
	
	@ElementCollection
	@Builder.Default
	private List<ProductImage> imageList = new ArrayList<>();

	public void addImage(ProductImage image) {
		image.setOrd(this.imageList.size());
		imageList.add(image);
	}
	
	public void addImageString(String fileName) {
		ProductImage productImage = ProductImage.builder()
				.fileName(fileName)
				.build();
		
		addImage(productImage);
	}
	
	
	public void changePname(String pname) {
		this.pname = pname;
	}

	public void changePrice(int price) {
		this.price = price;
	}

	public void changePdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public void changeDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	public void clearList() {
		this.imageList.clear();	
	}
	
	

	
	
	
	
}
